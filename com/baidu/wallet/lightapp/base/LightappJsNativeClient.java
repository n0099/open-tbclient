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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
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
    public static int f25464c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f25465d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static int f25466e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25467a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, ILightappInvokerCallback> f25468b;

    /* renamed from: f  reason: collision with root package name */
    public final String f25469f;

    /* renamed from: g  reason: collision with root package name */
    public final String f25470g;

    /* renamed from: h  reason: collision with root package name */
    public final String f25471h;

    /* renamed from: i  reason: collision with root package name */
    public final String f25472i;
    public final String j;
    public com.baidu.wallet.lightapp.multipage.a k;
    public String l;
    public int m;
    public int n;
    public int o;
    public String p;
    public Method q;
    public boolean r;
    public ILightappInvokerCallback s;
    public String t;
    public String u;

    /* loaded from: classes5.dex */
    public static class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ILightappInvokerCallback f25494a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25495b;

        /* renamed from: c  reason: collision with root package name */
        public final LocationManager f25496c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayList<String> f25497d;

        /* renamed from: e  reason: collision with root package name */
        public final LightAppNewLocationModel f25498e;

        public a(ILightappInvokerCallback iLightappInvokerCallback, String str, LocationManager locationManager, ArrayList<String> arrayList, LightAppNewLocationModel lightAppNewLocationModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iLightappInvokerCallback, str, locationManager, arrayList, lightAppNewLocationModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25494a = iLightappInvokerCallback;
            this.f25495b = str;
            this.f25496c = locationManager;
            this.f25497d = arrayList;
            this.f25498e = lightAppNewLocationModel;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (location != null) {
                    LightAppNewLocationModel lightAppNewLocationModel = this.f25498e;
                    lightAppNewLocationModel.result = 0;
                    lightAppNewLocationModel.cnt.data.latitude = location.getLatitude();
                    this.f25498e.cnt.data.longitude = location.getLongitude();
                    String json = this.f25498e.toJson();
                    this.f25494a.onResult(0, json);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f25495b);
                    arrayList.add(Base64Utils.encodeToString(json.getBytes()));
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_OK, arrayList);
                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_OK, arrayList);
                } else {
                    PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_FAIL, this.f25497d);
                    LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                    LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                    data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                    data.des = "定位失败";
                    this.f25494a.onResult(1, lightAppErrorModel.toJson());
                }
                this.f25496c.removeUpdates(this);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_FAIL, this.f25497d);
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                data.des = "定位失败";
                this.f25494a.onResult(1, lightAppErrorModel.toJson());
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, bundle) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1969172355, "Lcom/baidu/wallet/lightapp/base/LightappJsNativeClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1969172355, "Lcom/baidu/wallet/lightapp/base/LightappJsNativeClient;");
        }
    }

    public LightappJsNativeClient(com.baidu.wallet.lightapp.multipage.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25467a = LightappJsNativeClient.class.getSimpleName();
        this.f25468b = new HashMap<>();
        this.f25469f = "访问相机的权限";
        this.f25470g = "读写存储卡的权限";
        this.f25471h = "访问通信录的权限";
        this.f25472i = "获取地理位置的权限";
        this.j = "没有";
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = null;
        this.q = null;
        this.r = false;
        this.t = null;
        this.u = null;
        this.k = aVar;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || TextUtils.isEmpty(this.t)) {
            return;
        }
        d(this.k.getContext(), this.t, this.s, this.u);
        this.t = null;
        this.u = null;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.k.closeTopWebview();
        }
    }

    private void g(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, this, jSONObject, str) == null) {
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                LightappUtils.onError(this.f25468b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, "标题不能为空", "#insertCalendarEventFail");
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
                LightappUtils.onError(this.f25468b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, ResUtils.getString(this.k.getContext(), "insert_calendar_not_available"), LightAppStatEvent.LIGHT_APP_INSERT_CALENDAR_NOT_AVAILABLE);
                return;
            }
            String str2 = valueOf.longValue() < 0 ? "开始时间必须大于零" : "";
            if (valueOf2.longValue() < 0) {
                str2 = str2 + "结束时间必须大于零";
            }
            if (valueOf2.longValue() < valueOf.longValue()) {
                str2 = str2 + "结束时间必须大于开始时间";
            }
            LightappUtils.onError(this.f25468b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, str2, "#insertCalendarEventFail");
        }
    }

    public static Set<String> getSupportMethodList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
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
        return (Set) invokeL.objValue;
    }

    private void h(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, this, jSONObject, str) == null) {
            long optLong = jSONObject.optLong("beginTime");
            int i2 = (optLong > 0L ? 1 : (optLong == 0L ? 0 : -1));
            if (i2 < 0) {
                LightappUtils.onError(this.f25468b.get(VIEW_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, "时间必须大于零", "#viewCalendarEventFail");
                return;
            }
            if (i2 == 0) {
                optLong = Calendar.getInstance().getTimeInMillis();
            }
            Uri.Builder buildUpon = CalendarContract.CONTENT_URI.buildUpon();
            buildUpon.appendPath("time");
            ContentUris.appendId(buildUpon, optLong);
            Intent data = new Intent("android.intent.action.VIEW").setData(buildUpon.build());
            if (this.k.getActivity() != null && data.resolveActivity(this.k.getActivity().getPackageManager()) != null) {
                this.k.getActivity().startActivity(data);
            } else {
                LightappUtils.onError(this.f25468b.get(VIEW_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, ResUtils.getString(this.k.getContext(), "view_calendar_not_available"), LightAppStatEvent.LIGHT_APP_VIEW_CALENDAR_NOT_AVAILABLE);
            }
        }
    }

    private void i(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, this, jSONObject, str) == null) {
            ILightappInvokerCallback iLightappInvokerCallback = this.f25468b.get(ADJUST_SCREEN_BRIGHTNESS);
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
    }

    public void callShare(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, iLightappInvokerCallback, str2) == null) || TextUtils.isEmpty(str)) {
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
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str3));
        } catch (Exception unused2) {
        }
        PayStatisticsUtil.onEventWithValues("#callShare", arrayList);
        LightAppWrapper.getInstance().callShare(this.k.getActivity(), lightAppShareModel, new ILightappInvokerCallback(this, arrayList, iLightappInvokerCallback) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ArrayList f25489a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ILightappInvokerCallback f25490b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LightappJsNativeClient f25491c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, arrayList, iLightappInvokerCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25491c = this;
                this.f25489a = arrayList;
                this.f25490b = iLightappInvokerCallback;
            }

            @Override // com.baidu.wallet.api.ILightappInvokerCallback
            public void onResult(int i2, String str4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str4) == null) {
                    if (1 == i2) {
                        if (!TextUtils.isEmpty(str4)) {
                            this.f25489a.add(str4);
                        }
                        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_CALL_SHARE_FAIL, this.f25489a);
                    }
                    ILightappInvokerCallback iLightappInvokerCallback2 = this.f25490b;
                    if (iLightappInvokerCallback2 != null) {
                        iLightappInvokerCallback2.onResult(i2, str4);
                    }
                }
            }
        });
    }

    public void closeWindow(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
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
    }

    public void getBattery(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
        }
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getSupportMethodList(this.k.getContext()) : (Set) invokeV.objValue;
    }

    public void handleInsertEventDone(boolean z) {
        ILightappInvokerCallback iLightappInvokerCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (iLightappInvokerCallback = this.f25468b.get(INSERT_CALENDAR_EVENT)) == null) {
            return;
        }
        if (z) {
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_ACTION_WITHOUT_RESULT);
        iLightappInvokerCallback.onResult(1, LightappUtils.assembleResult((Map<String, Object>) hashMap, false));
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, context, str, iLightappInvokerCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method_name");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f25468b.put(string, iLightappInvokerCallback);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(0);
            ImageBase64Utils.getInstance().getImgageBase64(this.l, 640, new ImageBase64Utils.ImageBase64Listener(this, lightAppTakePictureModel) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LightAppTakePictureModel f25475a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappJsNativeClient f25476b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, lightAppTakePictureModel};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25476b = this;
                    this.f25475a = lightAppTakePictureModel;
                }

                @Override // com.baidu.apollon.utils.ImageBase64Utils.ImageBase64Listener
                public void onBase64Result(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        LightAppTakePictureModel lightAppTakePictureModel2 = this.f25475a;
                        lightAppTakePictureModel2.cnt.image = str;
                        this.f25476b.a(LightappBusinessClient.METHOD_CALL_CAMERA, 0, lightAppTakePictureModel2.toJson());
                        try {
                            File file = new File(this.f25476b.l);
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public void onContactsSelected(String str, int i2, String[] strArr, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, str, i2, strArr, str2) == null) {
            ContactSelectModel contactSelectModel = new ContactSelectModel();
            if (i2 != 0) {
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
                if (this.m == f25465d) {
                    PhoneContactsMananger.a(this.k.getContext()).a(new PhoneContactsMananger.d(this, contactSelectModel) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ContactSelectModel f25473a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LightappJsNativeClient f25474b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, contactSelectModel};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25474b = this;
                            this.f25473a = contactSelectModel;
                        }

                        @Override // com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger.d
                        public void a(List<ContactSelectModel.AllContact> list, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, list, i3) == null) {
                                if (this.f25474b.p != null) {
                                    this.f25473a.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), this.f25474b.p));
                                } else {
                                    this.f25473a.cnt.all = list;
                                }
                                if (this.f25474b.o != LightappJsNativeClient.f25466e) {
                                    this.f25474b.a("selectPhonefromAdressBook", 0, this.f25473a.toJson());
                                    return;
                                }
                                LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                                ContactSelectModel contactSelectModel2 = this.f25473a;
                                lightAppContactSelectModelBase64.result = contactSelectModel2.result;
                                ContactSelectModel.Data data2 = contactSelectModel2.cnt;
                                if (data2 != null) {
                                    lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data2).getBytes());
                                }
                                this.f25474b.a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
                            }
                        }
                    });
                    if (this.n > 0) {
                        PhoneContactsMananger.a(this.k.getContext()).a(this.n, false);
                    } else {
                        PhoneContactsMananger.a(this.k.getContext()).a(1000, false);
                    }
                } else if (this.o == f25466e) {
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
    }

    public void onRequestPermissionsResult(String str, int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, strArr, iArr) == null) {
            int i3 = 0;
            switch (i2) {
                case 209:
                    if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                        while (i3 < strArr.length) {
                            if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i3]) && i3 < iArr.length) {
                                int i4 = iArr[i3];
                                if (i4 == 0) {
                                    if (PermissionManager.checkCallingPermission(this.k.getActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                                        a(this.k.getActivity());
                                    } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 210)) {
                                        c();
                                    }
                                } else if (i4 == -1) {
                                    b();
                                }
                            }
                            i3++;
                        }
                        return;
                    }
                    b();
                    return;
                case 210:
                    if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                        while (i3 < strArr.length) {
                            if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i3]) && i3 < iArr.length) {
                                int i5 = iArr[i3];
                                if (i5 == 0) {
                                    if (PermissionManager.checkCallingPermission(this.k.getActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                                        a(this.k.getActivity());
                                    } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 209)) {
                                        b();
                                    }
                                } else if (i5 == -1) {
                                    c();
                                }
                            }
                            i3++;
                        }
                        return;
                    }
                    c();
                    return;
                case 211:
                    if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                        while (i3 < strArr.length) {
                            if ("android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i3]) && i3 < iArr.length) {
                                int i6 = iArr[i3];
                                if (i6 == 0) {
                                    d();
                                } else if (i6 == -1) {
                                    a(str);
                                }
                            }
                            i3++;
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
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
            LogUtil.d(lightAppTakePictureModel.toJson());
            LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有访问相机的权限";
            a(LightappBusinessClient.METHOD_CALL_CAMERA, 1, lightAppTakePictureModel.toJson());
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
            LogUtil.d(lightAppTakePictureModel.toJson());
            LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有读写存储卡的权限";
            a(LightappBusinessClient.METHOD_CALL_CAMERA, 1, lightAppTakePictureModel.toJson());
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            ContactManager.getIContactsImpl().pickContactsByContactsContentUri(this.k.getActivity(), 4);
        }
    }

    private void f(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, this, jSONObject, str) == null) {
            ILightappInvokerCallback iLightappInvokerCallback = this.f25468b.get(SCREEN_CAPTURE_SETTINGS);
            boolean optBoolean = jSONObject.optBoolean("prevent", false);
            if (this.k.getActivity() != null) {
                LightappUtils.runOnUiThread(new Runnable(this, optBoolean) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f25492a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LightappJsNativeClient f25493b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(optBoolean)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25493b = this;
                        this.f25492a = optBoolean;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.f25492a) {
                                BdWalletUtils.addFlagsSecure(this.f25493b.k.getActivity());
                            } else {
                                BdWalletUtils.clearFlagsSecure(this.f25493b.k.getActivity());
                            }
                        }
                    }
                });
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
                return;
            }
            iLightappInvokerCallback.onResult(1, LightappUtils.assembleFailResultWithErrCode(LightappConstants.ERRCODE_INNER_ERROR, "内部错误"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65560, this, context, str, iLightappInvokerCallback, str2) == null) {
            a(METHOD_GET_CURRENT_POSITION, str);
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(CheckUtils.stripUrlParams(str2));
            } catch (Exception unused) {
            }
            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS, arrayList);
            LightAppNewLocationModel lightAppNewLocationModel = new LightAppNewLocationModel();
            ILocationCallback iLocationCallback = new ILocationCallback(this, lightAppNewLocationModel, iLightappInvokerCallback, str2, arrayList) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LightAppNewLocationModel f25482a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f25483b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f25484c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ ArrayList f25485d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ LightappJsNativeClient f25486e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, lightAppNewLocationModel, iLightappInvokerCallback, str2, arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25486e = this;
                    this.f25482a = lightAppNewLocationModel;
                    this.f25483b = iLightappInvokerCallback;
                    this.f25484c = str2;
                    this.f25485d = arrayList;
                }

                @Override // com.baidu.wallet.api.ILocationCallback
                public void onReceiveLocation(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        if (obj != null && (obj instanceof LightAppLocationModel)) {
                            LightAppNewLocationModel lightAppNewLocationModel2 = this.f25482a;
                            lightAppNewLocationModel2.result = 0;
                            LightAppNewLocationModel.Loc loc = lightAppNewLocationModel2.cnt.data;
                            LightAppLocationModel.Coords coords = ((LightAppLocationModel) obj).coords;
                            loc.latitude = coords.latitude;
                            loc.longitude = coords.longitude;
                            String json = lightAppNewLocationModel2.toJson();
                            this.f25483b.onResult(0, json);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(this.f25484c);
                            arrayList2.add(Base64Utils.encodeToString(json.getBytes()));
                            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_OK, arrayList2);
                            PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_OK, arrayList2);
                            return;
                        }
                        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_FAIL, this.f25485d);
                        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                        data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                        data.des = "定位失败";
                        this.f25483b.onResult(1, lightAppErrorModel.toJson());
                    }
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
                    method.invoke(null, context, new InvocationHandler(this, iLocationCallback) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ILocationCallback f25487a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LightappJsNativeClient f25488b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iLocationCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25488b = this;
                            this.f25487a = iLocationCallback;
                        }

                        @Override // java.lang.reflect.InvocationHandler
                        public Object invoke(Object obj, Method method2, Object[] objArr) throws Throwable {
                            InterceptResult invokeLLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj, method2, objArr)) == null) {
                                if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0 && objArr.length >= 3) {
                                    LightAppLocationModel lightAppLocationModel = new LightAppLocationModel();
                                    lightAppLocationModel.result = 0;
                                    LightAppLocationModel.Coords coords = new LightAppLocationModel.Coords();
                                    lightAppLocationModel.coords = coords;
                                    coords.accuracy = ((Float) objArr[0]).floatValue();
                                    lightAppLocationModel.coords.latitude = ((Double) objArr[1]).doubleValue();
                                    lightAppLocationModel.coords.longitude = ((Double) objArr[2]).doubleValue();
                                    this.f25487a.onReceiveLocation(lightAppLocationModel);
                                } else {
                                    this.f25487a.onReceiveLocation(null);
                                }
                                return null;
                            }
                            return invokeLLL.objValue;
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
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, str, str2) == null) {
            LogUtil.logd("method:" + str + "#options=" + str2);
        }
    }

    private void e(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, this, jSONObject, str) == null) {
            this.k.preLoadException(jSONObject.optString("msg", ""));
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
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
    }

    private void e(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                l = Long.valueOf(new JSONObject(str).optLong("time", r9.longValue()));
            } catch (JSONException e2) {
                e2.printStackTrace();
                l = r9;
            }
            ((Vibrator) context.getSystemService("vibrator")).vibrate((l.longValue() > 0 ? l : 500L).longValue());
            iLightappInvokerCallback.onResult(0, "");
        }
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    private void c(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65556, this, context, str, iLightappInvokerCallback, str2) == null) {
            this.s = iLightappInvokerCallback;
            if (PermissionManager.checkCallingPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                d(context, str, iLightappInvokerCallback, str2);
                return;
            }
            this.t = str;
            this.u = str2;
            BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, this.k.getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, context, str, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f25477a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25478b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f25479c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f25480d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ LightappJsNativeClient f25481e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, iLightappInvokerCallback, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25481e = this;
                    this.f25477a = context;
                    this.f25478b = str;
                    this.f25479c = iLightappInvokerCallback;
                    this.f25480d = str2;
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        if (!bool.booleanValue()) {
                            this.f25481e.d(this.f25477a, this.f25478b, this.f25479c, this.f25480d);
                        } else if (PermissionManager.checkCallingOrSelfPermission(this.f25481e.k.getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 212)) {
                        } else {
                            this.f25481e.d(this.f25477a, this.f25478b, this.f25479c, this.f25480d);
                        }
                    }
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isShow(String str3, Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, bool) == null) {
                    }
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void requestResult(String str3, Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str3, bool) == null) {
                    }
                }
            });
        }
    }

    private void c(JSONObject jSONObject, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, this, jSONObject, str) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("url");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    String optString = jSONArray.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                i2 = jSONObject.optInt("life", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            if (arrayList.size() > 0) {
                this.k.preLoadUrl(arrayList, i2 > 0 ? i2 : -1);
            }
        }
    }

    private void d(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, this, jSONObject, str) == null) {
            com.baidu.wallet.core.utils.LogUtil.d("WEBLOG", jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, this, str, i2, str2) == null) {
            try {
                if (this.f25468b == null || (iLightappInvokerCallback = this.f25468b.get(str)) == null) {
                    return;
                }
                iLightappInvokerCallback.onResult(i2, str2);
                this.f25468b.remove(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                    if (this.m != f25464c && this.m != f25465d) {
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
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    throw new InvalidParameterException("参数格式非法");
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                ContactSelectModel contactSelectModel = new ContactSelectModel(1);
                ContactSelectModel.Data data = contactSelectModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INVALID_PARAMETER;
                data.des = e3.getLocalizedMessage();
                iLightappInvokerCallback.onResult(1, contactSelectModel.toJson());
            }
        }
    }

    private void b(Context context, String str, LightAppNewLocationModel lightAppNewLocationModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65552, this, context, str, lightAppNewLocationModel) == null) || context == null || this.s == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, this, jSONObject, str) == null) {
            String optString = jSONObject.optString("url", "");
            boolean equalsIgnoreCase = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH, "no").equalsIgnoreCase("yes");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.k.openInNewWebView(optString, equalsIgnoreCase);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
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
    }

    private void a(Context context, String str, LightAppNewLocationModel lightAppNewLocationModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, context, str, lightAppNewLocationModel) == null) || context == null || this.s == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, jSONObject, str) == null) {
            this.k.historyGo(jSONObject.optInt("index"));
        }
    }
}
