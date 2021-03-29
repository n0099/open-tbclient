package com.baidu.wallet.lightapp.base;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.Crypto;
import com.baidu.apollon.utils.ImageBase64Utils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.tbadk.TbConfig;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.ContactManager;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.DangerousPermissionUtils;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger;
import com.baidu.wallet.lightapp.base.datamodel.LightAppContactSelectModelBase64;
import com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppLocationModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppNewLocationModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppTakePictureModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LightappJsNativeClient implements ILightappInvoker {
    public static final String ADJUST_SCREEN_BRIGHTNESS = "adjustScreenBrightness";
    public static final int CONTRACT_FAIL = 1;
    public static final int CONTRACT_SUCCESS = 0;
    public static final int FIXED_CONTACT_SIZE = 1000;
    public static final int FIXED_IMAGE_WIDTH = 640;
    public static final String INSERT_CALENDAR_EVENT = "insertCalendarEvent";
    public static final int JS_CALL_CAMERA = 3;
    public static final int JS_CALL_SELECT_ADDRESS_BOOK = 3;
    public static final String METHOD_CALL_SHARE = "callShare";
    public static final String METHOD_CALL_VIBRATE = "callVibrate";
    public static final String METHOD_CLOSE_WINDOW = "closeWindow";
    public static final String METHOD_GET_CURRENT_POSITION = "getCurrentPosition";
    public static final String METHOD_GET_DEVIDE_INFO = "getDeviceInfo";
    public static final String METHOD_SELECT_CONTACTS = "selectPhonefromAdressBook";
    public static final String MW_CLOSE_TOP_WEBVIEW = "closeTopWebview";
    public static final String MW_HSITORY_GO = "historyGo";
    public static final String MW_NATIVE_LOG = "nativeLog";
    public static final String MW_OPEN_NEW_WEBVIEW = "openInNewWebView";
    public static final String MW_PRE_LOAD_EXCEPTION = "preLoadException";
    public static final String MW_PRE_LOAD_URL = "preLoadUrl";
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final String SCREEN_CAPTURE_SETTINGS = "screenCaptureSettings";
    public static final String VIEW_CALENDAR_EVENT = "viewCalendarEvent";

    /* renamed from: c  reason: collision with root package name */
    public static int f24843c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f24844d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static int f24845e = 1;
    public com.baidu.wallet.lightapp.multipage.a k;
    public String l;
    public ILightappInvokerCallback s;

    /* renamed from: a  reason: collision with root package name */
    public String f24846a = LightappJsNativeClient.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, ILightappInvokerCallback> f24847b = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final String f24848f = "访问相机的权限";

    /* renamed from: g  reason: collision with root package name */
    public final String f24849g = "读写存储卡的权限";

    /* renamed from: h  reason: collision with root package name */
    public final String f24850h = "访问通信录的权限";
    public final String i = "获取地理位置的权限";
    public final String j = "没有";
    public int m = -1;
    public int n = -1;
    public int o = -1;
    public String p = null;
    public Method q = null;
    public boolean r = false;
    public String t = null;
    public String u = null;

    /* loaded from: classes5.dex */
    public static class a implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        public final ILightappInvokerCallback f24872a;

        /* renamed from: b  reason: collision with root package name */
        public final String f24873b;

        /* renamed from: c  reason: collision with root package name */
        public final LocationManager f24874c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayList<String> f24875d;

        /* renamed from: e  reason: collision with root package name */
        public final LightAppNewLocationModel f24876e;

        public a(ILightappInvokerCallback iLightappInvokerCallback, String str, LocationManager locationManager, ArrayList<String> arrayList, LightAppNewLocationModel lightAppNewLocationModel) {
            this.f24872a = iLightappInvokerCallback;
            this.f24873b = str;
            this.f24874c = locationManager;
            this.f24875d = arrayList;
            this.f24876e = lightAppNewLocationModel;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                LightAppNewLocationModel lightAppNewLocationModel = this.f24876e;
                lightAppNewLocationModel.result = 0;
                lightAppNewLocationModel.cnt.data.latitude = location.getLatitude();
                this.f24876e.cnt.data.longitude = location.getLongitude();
                String json = this.f24876e.toJson();
                this.f24872a.onResult(0, json);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f24873b);
                arrayList.add(Base64Utils.encodeToString(json.getBytes()));
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_OK, arrayList);
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_OK, arrayList);
            } else {
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_FAIL, this.f24875d);
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                data.des = "定位失败";
                this.f24872a.onResult(1, lightAppErrorModel.toJson());
            }
            this.f24874c.removeUpdates(this);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_FAIL, this.f24875d);
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
            data.des = "定位失败";
            this.f24872a.onResult(1, lightAppErrorModel.toJson());
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public LightappJsNativeClient(com.baidu.wallet.lightapp.multipage.a aVar) {
        this.k = aVar;
    }

    private void e() {
        if (TextUtils.isEmpty(this.t)) {
            return;
        }
        d(this.k.getContext(), this.t, this.s, this.u);
        this.t = null;
        this.u = null;
    }

    private void f() {
        this.k.closeTopWebview();
    }

    private void g(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString)) {
            LightappUtils.onError(this.f24847b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, "标题不能为空", "#insertCalendarEventFail");
            return;
        }
        Long valueOf = Long.valueOf(jSONObject.optLong("beginTime"));
        Long valueOf2 = Long.valueOf(jSONObject.optLong("endTime"));
        if (valueOf.longValue() >= 0 && valueOf2.longValue() >= 0 && valueOf2.longValue() >= valueOf.longValue()) {
            Intent putExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("title", optString).putExtra("beginTime", valueOf).putExtra("endTime", valueOf2).putExtra("allDay", jSONObject.optBoolean("allDay")).putExtra("eventLocation", jSONObject.optString("eventLocation")).putExtra("description", jSONObject.optString("description")).putExtra("rrule", jSONObject.optString("rrule"));
            if (this.k.getActivity() != null && putExtra.resolveActivity(this.k.getActivity().getPackageManager()) != null) {
                this.k.getActivity().startActivityForResult(putExtra, 6);
                return;
            }
            Toast.makeText(this.k.getActivity(), ResUtils.string(this.k.getActivity(), "insert_calendar_not_available"), 1).show();
            LightappUtils.onError(this.f24847b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, ResUtils.getString(this.k.getContext(), "insert_calendar_not_available"), LightAppStatEvent.LIGHT_APP_INSERT_CALENDAR_NOT_AVAILABLE);
            return;
        }
        String str2 = valueOf.longValue() < 0 ? "开始时间必须大于零" : "";
        if (valueOf2.longValue() < 0) {
            str2 = str2 + "结束时间必须大于零";
        }
        if (valueOf2.longValue() < valueOf.longValue()) {
            str2 = str2 + "结束时间必须大于开始时间";
        }
        LightappUtils.onError(this.f24847b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, str2, "#insertCalendarEventFail");
    }

    public static Set<String> getSupportMethodList(Context context) {
        HashSet hashSet = new HashSet();
        hashSet.add("selectPhonefromAdressBook");
        hashSet.add("getDeviceInfo");
        hashSet.add(METHOD_CLOSE_WINDOW);
        hashSet.add(METHOD_GET_CURRENT_POSITION);
        hashSet.add(METHOD_CALL_SHARE);
        hashSet.add(INSERT_CALENDAR_EVENT);
        hashSet.add(VIEW_CALENDAR_EVENT);
        hashSet.add(ADJUST_SCREEN_BRIGHTNESS);
        hashSet.add(SCREEN_CAPTURE_SETTINGS);
        hashSet.add(METHOD_CALL_VIBRATE);
        LangbridgeSettings a2 = h.a().a(context);
        if (a2.MW_ON && a2.MW_MULTI_ON) {
            hashSet.add(MW_OPEN_NEW_WEBVIEW);
            hashSet.add(MW_CLOSE_TOP_WEBVIEW);
            hashSet.add(MW_PRE_LOAD_URL);
            hashSet.add(MW_PRE_LOAD_EXCEPTION);
        }
        hashSet.add(MW_HSITORY_GO);
        hashSet.add(MW_NATIVE_LOG);
        return hashSet;
    }

    private void h(JSONObject jSONObject, String str) {
        long optLong = jSONObject.optLong("beginTime");
        int i = (optLong > 0L ? 1 : (optLong == 0L ? 0 : -1));
        if (i < 0) {
            LightappUtils.onError(this.f24847b.get(VIEW_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, "时间必须大于零", "#viewCalendarEventFail");
            return;
        }
        if (i == 0) {
            optLong = Calendar.getInstance().getTimeInMillis();
        }
        Uri.Builder buildUpon = CalendarContract.CONTENT_URI.buildUpon();
        buildUpon.appendPath("time");
        ContentUris.appendId(buildUpon, optLong);
        Intent data = new Intent("android.intent.action.VIEW").setData(buildUpon.build());
        if (this.k.getActivity() != null && data.resolveActivity(this.k.getActivity().getPackageManager()) != null) {
            this.k.getActivity().startActivity(data);
        } else {
            LightappUtils.onError(this.f24847b.get(VIEW_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, ResUtils.getString(this.k.getContext(), "view_calendar_not_available"), LightAppStatEvent.LIGHT_APP_VIEW_CALENDAR_NOT_AVAILABLE);
        }
    }

    private void i(JSONObject jSONObject, String str) {
        ILightappInvokerCallback iLightappInvokerCallback = this.f24847b.get(ADJUST_SCREEN_BRIGHTNESS);
        if (this.k.getActivity() == null) {
            iLightappInvokerCallback.onResult(1, LightappUtils.assembleFailResultWithErrCode(LightappConstants.ERRCODE_INNER_ERROR, "内部错误"));
            return;
        }
        try {
            c.a((float) jSONObject.getDouble("brightness"), this.k.getActivity());
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
        } catch (JSONException unused) {
            iLightappInvokerCallback.onResult(1, LightappUtils.assembleFailResultWithErrCode(LightappConstants.ERRCODE_INVALID_PARAMETER, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR));
        }
    }

    public void callShare(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LightAppShareModel lightAppShareModel = null;
        try {
            lightAppShareModel = (LightAppShareModel) JsonUtils.fromJson(str, LightAppShareModel.class);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (lightAppShareModel == null || !lightAppShareModel.valid()) {
            return;
        }
        try {
            str3 = new JSONObject(str).getString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
        } catch (Exception unused) {
            str3 = "";
        }
        final ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str3));
        } catch (Exception unused2) {
        }
        PayStatisticsUtil.onEventWithValues("#callShare", arrayList);
        LightAppWrapper.getInstance().callShare(this.k.getActivity(), lightAppShareModel, new ILightappInvokerCallback() { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.6
            @Override // com.baidu.wallet.api.ILightappInvokerCallback
            public void onResult(int i, String str4) {
                if (1 == i) {
                    if (!TextUtils.isEmpty(str4)) {
                        arrayList.add(str4);
                    }
                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CALL_SHARE_FAIL, arrayList);
                }
                ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                if (iLightappInvokerCallback2 != null) {
                    iLightappInvokerCallback2.onResult(i, str4);
                }
            }
        });
    }

    public void closeWindow(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str));
        } catch (Exception unused) {
        }
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CLOSE_WINDOW, arrayList);
        com.baidu.wallet.lightapp.multipage.a aVar = this.k;
        if (aVar != null) {
            aVar.closeWindow();
        }
    }

    public void getBattery(String str, String str2) {
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        return getSupportMethodList(this.k.getContext());
    }

    public void handleInsertEventDone(boolean z) {
        ILightappInvokerCallback iLightappInvokerCallback = this.f24847b.get(INSERT_CALENDAR_EVENT);
        if (iLightappInvokerCallback != null) {
            if (z) {
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_ACTION_WITHOUT_RESULT);
            iLightappInvokerCallback.onResult(1, LightappUtils.assembleResult((Map<String, Object>) hashMap, false));
        }
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method_name");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f24847b.put(string, iLightappInvokerCallback);
            String string2 = jSONObject.getString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            if (!JavascriptInterfaceManager.verifyPermission(new URL(string2), string)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(CheckUtils.stripUrlParams(string2));
                arrayList.add(string);
                LightappUtils.onError(iLightappInvokerCallback, LightappConstants.ERRCODE_HOST_NOT_AUTHORITY, ResUtils.getString(context, "host_not_authority"), LightAppStatEvent.LIGHT_APP_NOT_INTERNAL_URL, arrayList);
            } else if ("selectPhonefromAdressBook".equals(string)) {
                a(context, str, iLightappInvokerCallback, string2);
            } else if ("getDeviceInfo".equals(string)) {
                b(context, str, iLightappInvokerCallback, string2);
            } else if (METHOD_CLOSE_WINDOW.equals(string)) {
                closeWindow(string2);
            } else if (METHOD_GET_CURRENT_POSITION.equals(string)) {
                c(context, str, iLightappInvokerCallback, string2);
            } else if (METHOD_CALL_SHARE.equals(string)) {
                callShare(context, str, iLightappInvokerCallback, string2);
            } else if (INSERT_CALENDAR_EVENT.equals(string)) {
                g(jSONObject, string2);
            } else if (VIEW_CALENDAR_EVENT.equals(string)) {
                h(jSONObject, string2);
            } else if (ADJUST_SCREEN_BRIGHTNESS.equals(string)) {
                i(jSONObject, string2);
            } else if (SCREEN_CAPTURE_SETTINGS.equals(string)) {
                f(jSONObject, string2);
            } else if (METHOD_CALL_VIBRATE.equals(string)) {
                e(context, str, iLightappInvokerCallback, string2);
            } else if (MW_OPEN_NEW_WEBVIEW.equals(string)) {
                b(jSONObject, string2);
            } else if (MW_PRE_LOAD_URL.equals(string)) {
                c(jSONObject, string2);
            } else if (MW_HSITORY_GO.equals(string)) {
                a(jSONObject, string2);
            } else if (MW_NATIVE_LOG.equals(string)) {
                d(jSONObject, string2);
            } else if (MW_PRE_LOAD_EXCEPTION.equals(string)) {
                e(jSONObject, string2);
            } else if (MW_CLOSE_TOP_WEBVIEW.equals(string)) {
                f();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onCallCameraPicCallback() {
        final LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(0);
        ImageBase64Utils.getInstance().getImgageBase64(this.l, 640, new ImageBase64Utils.ImageBase64Listener() { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.2
            @Override // com.baidu.apollon.utils.ImageBase64Utils.ImageBase64Listener
            public void onBase64Result(String str) {
                LightAppTakePictureModel lightAppTakePictureModel2 = lightAppTakePictureModel;
                lightAppTakePictureModel2.cnt.image = str;
                LightappJsNativeClient.this.a(LightappBusinessClient.METHOD_CALL_CAMERA, 0, lightAppTakePictureModel2.toJson());
                try {
                    File file = new File(LightappJsNativeClient.this.l);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void onContactsSelected(String str, int i, String[] strArr, String str2) {
        final ContactSelectModel contactSelectModel = new ContactSelectModel();
        if (i != 0) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(CheckUtils.stripUrlParams(str));
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_SELECT_ADDRESSBOOK_FAIL, arrayList);
            contactSelectModel.result = 1;
            ContactSelectModel.Data data = contactSelectModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = str2;
            a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
        } else if (strArr != null) {
            String str3 = strArr.length > 0 ? strArr[0] : "";
            String str4 = strArr.length > 1 ? strArr[1] : "";
            contactSelectModel.result = 0;
            ContactSelectModel.SelectedContact selectedContact = contactSelectModel.cnt.selected;
            selectedContact.name = str3;
            selectedContact.phone = str4;
            if (this.m == f24844d) {
                PhoneContactsMananger.a(this.k.getContext()).a(new PhoneContactsMananger.d() { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.1
                    @Override // com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger.d
                    public void a(List<ContactSelectModel.AllContact> list, int i2) {
                        if (LightappJsNativeClient.this.p != null) {
                            contactSelectModel.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), LightappJsNativeClient.this.p));
                        } else {
                            contactSelectModel.cnt.all = list;
                        }
                        if (LightappJsNativeClient.this.o != LightappJsNativeClient.f24845e) {
                            LightappJsNativeClient.this.a("selectPhonefromAdressBook", 0, contactSelectModel.toJson());
                            return;
                        }
                        LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                        ContactSelectModel contactSelectModel2 = contactSelectModel;
                        lightAppContactSelectModelBase64.result = contactSelectModel2.result;
                        ContactSelectModel.Data data2 = contactSelectModel2.cnt;
                        if (data2 != null) {
                            lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data2).getBytes());
                        }
                        LightappJsNativeClient.this.a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
                    }
                });
                if (this.n > 0) {
                    PhoneContactsMananger.a(this.k.getContext()).a(this.n, false);
                } else {
                    PhoneContactsMananger.a(this.k.getContext()).a(1000, false);
                }
            } else if (this.o == f24845e) {
                LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                lightAppContactSelectModelBase64.result = contactSelectModel.result;
                ContactSelectModel.Data data2 = contactSelectModel.cnt;
                if (data2 != null) {
                    lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data2).getBytes());
                }
                a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
            } else {
                a("selectPhonefromAdressBook", 0, contactSelectModel.toJson());
            }
        }
    }

    public void onRequestPermissionsResult(String str, int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        switch (i) {
            case 209:
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    while (i2 < strArr.length) {
                        if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i2]) && i2 < iArr.length) {
                            int i3 = iArr[i2];
                            if (i3 == 0) {
                                if (PermissionManager.checkCallingPermission(this.k.getActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                                    a(this.k.getActivity());
                                } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST)) {
                                    c();
                                }
                            } else if (i3 == -1) {
                                b();
                            }
                        }
                        i2++;
                    }
                    return;
                }
                b();
                return;
            case Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST /* 210 */:
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    while (i2 < strArr.length) {
                        if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i2]) && i2 < iArr.length) {
                            int i4 = iArr[i2];
                            if (i4 == 0) {
                                if (PermissionManager.checkCallingPermission(this.k.getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                                    a(this.k.getActivity());
                                } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 209)) {
                                    b();
                                }
                            } else if (i4 == -1) {
                                c();
                            }
                        }
                        i2++;
                    }
                    return;
                }
                c();
                return;
            case 211:
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    while (i2 < strArr.length) {
                        if ("android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i2]) && i2 < iArr.length) {
                            int i5 = iArr[i2];
                            if (i5 == 0) {
                                d();
                            } else if (i5 == -1) {
                                a(str);
                            }
                        }
                        i2++;
                    }
                    return;
                }
                a(str);
                return;
            case 212:
                e();
                if (iArr == null || iArr[0] == 0) {
                    return;
                }
                DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_NO_PERMISSION);
                return;
            default:
                return;
        }
    }

    private void b() {
        LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
        LogUtil.d(lightAppTakePictureModel.toJson());
        LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
        data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
        data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有访问相机的权限";
        a(LightappBusinessClient.METHOD_CALL_CAMERA, 1, lightAppTakePictureModel.toJson());
    }

    private void c() {
        LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
        LogUtil.d(lightAppTakePictureModel.toJson());
        LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
        data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
        data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有读写存储卡的权限";
        a(LightappBusinessClient.METHOD_CALL_CAMERA, 1, lightAppTakePictureModel.toJson());
    }

    private void d() {
        ContactManager.getIContactsImpl().pickContactsByContactsContentUri(this.k.getActivity(), 4);
    }

    private void f(JSONObject jSONObject, String str) {
        ILightappInvokerCallback iLightappInvokerCallback = this.f24847b.get(SCREEN_CAPTURE_SETTINGS);
        final boolean optBoolean = jSONObject.optBoolean("prevent", false);
        if (this.k.getActivity() != null) {
            LightappUtils.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.7
                @Override // java.lang.Runnable
                public void run() {
                    if (optBoolean) {
                        BdWalletUtils.addFlagsSecure(LightappJsNativeClient.this.k.getActivity());
                    } else {
                        BdWalletUtils.clearFlagsSecure(LightappJsNativeClient.this.k.getActivity());
                    }
                }
            });
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
            return;
        }
        iLightappInvokerCallback.onResult(1, LightappUtils.assembleFailResultWithErrCode(LightappConstants.ERRCODE_INNER_ERROR, "内部错误"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        a(METHOD_GET_CURRENT_POSITION, str);
        final ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str2));
        } catch (Exception unused) {
        }
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS, arrayList);
        final LightAppNewLocationModel lightAppNewLocationModel = new LightAppNewLocationModel();
        final ILocationCallback iLocationCallback = new ILocationCallback() { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.4
            @Override // com.baidu.wallet.api.ILocationCallback
            public void onReceiveLocation(Object obj) {
                if (obj != null && (obj instanceof LightAppLocationModel)) {
                    LightAppNewLocationModel lightAppNewLocationModel2 = lightAppNewLocationModel;
                    lightAppNewLocationModel2.result = 0;
                    LightAppNewLocationModel.Loc loc = lightAppNewLocationModel2.cnt.data;
                    LightAppLocationModel.Coords coords = ((LightAppLocationModel) obj).coords;
                    loc.latitude = coords.latitude;
                    loc.longitude = coords.longitude;
                    String json = lightAppNewLocationModel2.toJson();
                    iLightappInvokerCallback.onResult(0, json);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    arrayList2.add(Base64Utils.encodeToString(json.getBytes()));
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_OK, arrayList2);
                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_OK, arrayList2);
                    return;
                }
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_FAIL, arrayList);
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                data.des = "定位失败";
                iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
            }
        };
        if (LightAppWrapper.getInstance().getCurrentLocation(iLocationCallback)) {
            return;
        }
        if (!this.r) {
            try {
                try {
                    this.q = Class.forName("com.baidu.wallet.locationsdk.LocationInvoker").getDeclaredMethod("getLocation", Context.class, InvocationHandler.class);
                } catch (Throwable unused2) {
                    LogUtil.d("InvokeLocatonLib", "lib reflect fail");
                }
            } finally {
                this.r = true;
            }
        }
        Method method = this.q;
        if (method != null) {
            try {
                method.invoke(null, context, new InvocationHandler() { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.5
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method2, Object[] objArr) throws Throwable {
                        if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0 && objArr.length >= 3) {
                            LightAppLocationModel lightAppLocationModel = new LightAppLocationModel();
                            lightAppLocationModel.result = 0;
                            LightAppLocationModel.Coords coords = new LightAppLocationModel.Coords();
                            lightAppLocationModel.coords = coords;
                            coords.accuracy = ((Float) objArr[0]).floatValue();
                            lightAppLocationModel.coords.latitude = ((Double) objArr[1]).doubleValue();
                            lightAppLocationModel.coords.longitude = ((Double) objArr[2]).doubleValue();
                            iLocationCallback.onReceiveLocation(lightAppLocationModel);
                        } else {
                            iLocationCallback.onReceiveLocation(null);
                        }
                        return null;
                    }
                });
            } catch (Throwable unused3) {
                iLocationCallback.onReceiveLocation(null);
                LogUtil.d("InvokeLocatonLib", "lib invoke fail");
            }
        } else if (PermissionManager.checkCallingPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            b(context, str2, lightAppNewLocationModel);
        } else {
            a(context, str2, lightAppNewLocationModel);
        }
    }

    private void a(String str, String str2) {
        LogUtil.logd("method:" + str + "#options=" + str2);
    }

    private void e(JSONObject jSONObject, String str) {
        this.k.preLoadException(jSONObject.optString("msg", ""));
    }

    private void a(Context context) {
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if (externalStoragePublicDirectory != null && !externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
            if (externalStoragePublicDirectory == null) {
                return;
            }
            File file = new File(externalStoragePublicDirectory.getAbsolutePath() + File.separator + "call_camera.jpg");
            if (file.exists()) {
                file.delete();
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                intent.putExtra("output", Uri.fromFile(file));
                this.k.getActivity().startActivityForResult(intent, 3);
                this.l = file.getAbsolutePath();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
            LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
            data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
            data.des = e2.getMessage();
            a(LightappBusinessClient.METHOD_CALL_CAMERA, 1, lightAppTakePictureModel.toJson());
        }
    }

    private void e(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Long l;
        try {
            l = Long.valueOf(new JSONObject(str).optLong("time", r9.longValue()));
        } catch (JSONException e2) {
            e2.printStackTrace();
            l = r9;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate((l.longValue() > 0 ? l : 500L).longValue());
        iLightappInvokerCallback.onResult(0, "");
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        a("getDeviceInfo", str);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str2));
        } catch (Exception unused) {
        }
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_DEVICE_INFO, arrayList);
        LightAppDeviceInfoModel lightAppDeviceInfoModel = new LightAppDeviceInfoModel(0);
        try {
            lightAppDeviceInfoModel.cnt.data.BAIDUCUID = DeviceId.getCUID(context);
        } catch (Exception unused2) {
        }
        lightAppDeviceInfoModel.cnt.data.cuid = PhoneUtils.getCUID(context);
        LightAppDeviceInfoModel.DeviceInfo deviceInfo = lightAppDeviceInfoModel.cnt.data;
        deviceInfo.os = "Android";
        deviceInfo.brand = Build.BRAND;
        deviceInfo.version = Build.VERSION.RELEASE;
        deviceInfo.model = Build.MODEL;
        deviceInfo.ip = PhoneUtils.getIpInfo();
        String applicationName = PhoneUtils.getApplicationName(context);
        String appVersionName = PhoneUtils.getAppVersionName(context);
        LightAppDeviceInfoModel.DeviceInfo deviceInfo2 = lightAppDeviceInfoModel.cnt.data;
        deviceInfo2.appversioncode = PhoneUtils.getAppVersionCode(context) + "";
        deviceInfo2.appversionname = appVersionName;
        deviceInfo2.name = applicationName;
        deviceInfo2.ua = BussinessUtils.getUA(context);
        lightAppDeviceInfoModel.cnt.data.networktype = "" + NetworkUtils.getNetworkType(context);
        String phisicalMac = PhoneUtils.getPhisicalMac(context);
        lightAppDeviceInfoModel.cnt.data.macAddress = phisicalMac != null ? phisicalMac : "";
        String json = lightAppDeviceInfoModel.toJson();
        a("getDeviceInfo", 0, json);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(str2);
        arrayList2.add(Base64Utils.encodeToString(json.getBytes()));
        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_DEVICE_INFO_OK, arrayList2);
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_DEVICE_INFO_OK, arrayList2);
    }

    private void c(final Context context, final String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        this.s = iLightappInvokerCallback;
        if (PermissionManager.checkCallingPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            d(context, str, iLightappInvokerCallback, str2);
            return;
        }
        this.t = str;
        this.u = str2;
        BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, this.k.getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.3
            @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
            public void isAllAgree(Boolean bool) {
                if (!bool.booleanValue()) {
                    LightappJsNativeClient.this.d(context, str, iLightappInvokerCallback, str2);
                } else if (PermissionManager.checkCallingOrSelfPermission(LightappJsNativeClient.this.k.getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 212)) {
                } else {
                    LightappJsNativeClient.this.d(context, str, iLightappInvokerCallback, str2);
                }
            }

            @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
            public void isShow(String str3, Boolean bool) {
            }

            @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
            public void requestResult(String str3, Boolean bool) {
            }
        });
    }

    private void c(JSONObject jSONObject, String str) {
        int i;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("url");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            i = jSONObject.optInt("life", -1);
        } catch (JSONException e2) {
            e2.printStackTrace();
            i = -1;
        }
        if (arrayList.size() > 0) {
            this.k.preLoadUrl(arrayList, i > 0 ? i : -1);
        }
    }

    private void d(JSONObject jSONObject, String str) {
        com.baidu.wallet.core.utils.LogUtil.d("WEBLOG", jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback;
        try {
            if (this.f24847b == null || (iLightappInvokerCallback = this.f24847b.get(str)) == null) {
                return;
            }
            iLightappInvokerCallback.onResult(i, str2);
            this.f24847b.remove(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        a("selectPhonefromAdressBook", str);
        try {
            try {
                String optString = new JSONObject(str).optString("key", null);
                this.p = optString;
                if (optString != null && optString.trim().length() == 0) {
                    throw new InvalidParameterException("加密密钥格式非法");
                }
                this.m = LightappUtils.parseJsonInt(str, "type");
                this.n = LightappUtils.parseJsonInt(str, "maxNum");
                this.o = LightappUtils.parseJsonInt(str, "base64");
                if (this.m != f24843c && this.m != f24844d) {
                    throw new InvalidParameterException("参数非法");
                }
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(CheckUtils.stripUrlParams(str2));
                } catch (Exception unused) {
                }
                arrayList.add(this.m + "");
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_SELECT_PHONE_FROM_ADDRESSBOOK, arrayList);
                if (PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
                    d();
                } else if (PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, 211)) {
                } else {
                    a(str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ContactSelectModel contactSelectModel = new ContactSelectModel(1);
                ContactSelectModel.Data data = contactSelectModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INVALID_PARAMETER;
                data.des = e2.getLocalizedMessage();
                iLightappInvokerCallback.onResult(1, contactSelectModel.toJson());
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
            throw new InvalidParameterException("参数格式非法");
        }
    }

    private void b(Context context, String str, LightAppNewLocationModel lightAppNewLocationModel) {
        if (context == null || this.s == null) {
            return;
        }
        if (lightAppNewLocationModel == null) {
            lightAppNewLocationModel = new LightAppNewLocationModel();
        }
        LightAppNewLocationModel lightAppNewLocationModel2 = lightAppNewLocationModel;
        LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
        if (locationManager != null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(CheckUtils.stripUrlParams(str));
            } catch (Exception unused) {
            }
            locationManager.requestLocationUpdates("network", 0L, 0.0f, new a(this.s, str, locationManager, arrayList, lightAppNewLocationModel2));
        }
    }

    private void b(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("url", "");
        boolean equalsIgnoreCase = jSONObject.optString("root", "no").equalsIgnoreCase("yes");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.k.openInNewWebView(optString, equalsIgnoreCase);
    }

    private void a(String str) {
        ContactSelectModel contactSelectModel = new ContactSelectModel(1);
        ContactSelectModel.Data data = contactSelectModel.cnt;
        data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
        data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有访问通信录的权限";
        a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str));
        } catch (Exception unused) {
        }
        arrayList.add(contactSelectModel.cnt.des);
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_SELECT_ADDRESSBOOK_FAIL, arrayList);
    }

    private void a(Context context, String str, LightAppNewLocationModel lightAppNewLocationModel) {
        if (context == null || this.s == null) {
            return;
        }
        if (lightAppNewLocationModel == null) {
            lightAppNewLocationModel = new LightAppNewLocationModel();
        }
        lightAppNewLocationModel.result = 1;
        LightAppNewLocationModel.Data data = lightAppNewLocationModel.cnt;
        data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
        data.des = PhoneUtils.getApplicationName(context) + "没有获取地理位置的权限";
        a(METHOD_GET_CURRENT_POSITION, 1, lightAppNewLocationModel.toJson());
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str));
        } catch (Exception unused) {
        }
        arrayList.add(lightAppNewLocationModel.cnt.des);
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_FAIL, arrayList);
    }

    private void a(JSONObject jSONObject, String str) {
        this.k.historyGo(jSONObject.optInt("index"));
    }
}
