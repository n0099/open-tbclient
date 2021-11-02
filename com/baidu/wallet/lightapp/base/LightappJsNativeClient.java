package com.baidu.wallet.lightapp.base;

import android.content.ActivityNotFoundException;
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
import android.os.Looper;
import android.os.Vibrator;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.Crypto;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ImageBase64Utils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
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
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LocationCache;
import com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger;
import com.baidu.wallet.lightapp.base.datamodel.LightAppContactSelectModelBase64;
import com.baidu.wallet.lightapp.base.datamodel.LightAppDeviceInfoModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppLocationModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppNewLocationModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppTakePictureModel;
import com.baidu.wallet.lightapp.base.datamodel.LocationProvider;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.LightappBrowseActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.i;
import com.baidu.wallet.lightapp.multipage.j;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.webkit.sdk.PermissionRequest;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.qq.e.comm.constants.Constants;
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
import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
    public static final String MW_GET_LANGBRIDGE_HASH_STAMP = "getLangbridgeHashStamp";
    public static final String MW_GET_LANGBRIDGE_SETTINGS = "getLangbridgeSettings";
    public static final String MW_HSITORY_GO = "historyGo";
    public static final String MW_IS_PRELOADED = "isPreloaded";
    public static final String MW_NATIVE_LOG = "nativeLog";
    public static final String MW_OPEN_NEW_WEBVIEW = "openInNewWebView";
    public static final String MW_PRE_LOAD_EXCEPTION = "preLoadException";
    public static final String MW_PRE_LOAD_URL = "preLoadUrl";
    public static final String MW_RM_FROM_PRELOAD_POOL = "rmFromPreloadPool";
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final String SCREEN_CAPTURE_SETTINGS = "screenCaptureSettings";
    public static final String VIEW_CALENDAR_EVENT = "viewCalendarEvent";

    /* renamed from: c  reason: collision with root package name */
    public static int f58724c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f58725d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static int f58726e = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f58727a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, ILightappInvokerCallback> f58728b;

    /* renamed from: f  reason: collision with root package name */
    public final String f58729f;

    /* renamed from: g  reason: collision with root package name */
    public final String f58730g;

    /* renamed from: h  reason: collision with root package name */
    public final String f58731h;

    /* renamed from: i  reason: collision with root package name */
    public final String f58732i;
    public final String j;
    public com.baidu.wallet.lightapp.multipage.a k;
    public String l;
    public int m;
    public int n;
    public int o;
    public String p;
    public Method q;
    public boolean r;
    public LocationProvider s;
    public ILightappInvokerCallback t;
    public String u;
    public String v;

    /* loaded from: classes10.dex */
    public static class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ILightappInvokerCallback f58750a;

        /* renamed from: b  reason: collision with root package name */
        public final String f58751b;

        /* renamed from: c  reason: collision with root package name */
        public final LocationManager f58752c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayList<String> f58753d;

        /* renamed from: e  reason: collision with root package name */
        public final LightAppNewLocationModel f58754e;

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
            this.f58750a = iLightappInvokerCallback;
            this.f58751b = str;
            this.f58752c = locationManager;
            this.f58753d = arrayList;
            this.f58754e = lightAppNewLocationModel;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (location != null) {
                    LightAppNewLocationModel lightAppNewLocationModel = this.f58754e;
                    lightAppNewLocationModel.result = 0;
                    lightAppNewLocationModel.cnt.data.latitude = location.getLatitude();
                    this.f58754e.cnt.data.longitude = location.getLongitude();
                    this.f58750a.onResult(0, this.f58754e.toJson());
                    LocationCache.a(location.getLatitude(), location.getLongitude(), LocationCache.Coord.WGS84, LocationProvider.SYSTEM);
                } else {
                    LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                    LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                    data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                    data.des = "定位失败";
                    this.f58750a.onResult(1, lightAppErrorModel.toJson());
                }
                this.f58752c.removeUpdates(this);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                data.des = "定位失败";
                this.f58750a.onResult(1, lightAppErrorModel.toJson());
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
        this.f58727a = LightappJsNativeClient.class.getSimpleName();
        this.f58728b = new HashMap<>();
        this.f58729f = "访问相机的权限";
        this.f58730g = "读写存储卡的权限";
        this.f58731h = "访问通信录的权限";
        this.f58732i = "获取地理位置的权限";
        this.j = "没有";
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = LocationProvider.HOST;
        this.u = null;
        this.v = null;
        this.k = aVar;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || this.t == null) {
            return;
        }
        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
        data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
        data.des = "定位失败";
        this.t.onResult(1, lightAppErrorModel.toJson());
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            this.k.rmFromPreloadPool();
        }
    }

    public static Set<String> getSupportMethodList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
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
            LangbridgeSettings a2 = i.a().a(context);
            if (a2.MW_ON && a2.MW_MULTI_ON) {
                hashSet.add(MW_OPEN_NEW_WEBVIEW);
                hashSet.add(MW_CLOSE_TOP_WEBVIEW);
                hashSet.add(MW_PRE_LOAD_URL);
                hashSet.add(MW_PRE_LOAD_EXCEPTION);
            }
            hashSet.add(MW_HSITORY_GO);
            hashSet.add(MW_NATIVE_LOG);
            hashSet.add(MW_IS_PRELOADED);
            hashSet.add(MW_RM_FROM_PRELOAD_POOL);
            hashSet.add(MW_GET_LANGBRIDGE_HASH_STAMP);
            hashSet.add(MW_GET_LANGBRIDGE_SETTINGS);
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.k.closeTopWebview();
        }
    }

    private void i(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65576, this, jSONObject, str) == null) {
            ILightappInvokerCallback iLightappInvokerCallback = this.f58728b.get(ADJUST_SCREEN_BRIGHTNESS);
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
        LightAppWrapper.getInstance().callShare(this.k.getActivity(), lightAppShareModel, new ILightappInvokerCallback(this, arrayList, iLightappInvokerCallback) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ArrayList f58745a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ILightappInvokerCallback f58746b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LightappJsNativeClient f58747c;

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
                this.f58747c = this;
                this.f58745a = arrayList;
                this.f58746b = iLightappInvokerCallback;
            }

            @Override // com.baidu.wallet.api.ILightappInvokerCallback
            public void onResult(int i2, String str4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str4) == null) {
                    if (1 == i2 && !TextUtils.isEmpty(str4)) {
                        this.f58745a.add(str4);
                    }
                    ILightappInvokerCallback iLightappInvokerCallback2 = this.f58746b;
                    if (iLightappInvokerCallback2 != null) {
                        iLightappInvokerCallback2.onResult(i2, str4);
                    }
                }
            }
        });
    }

    public void closeWindow(String str) {
        com.baidu.wallet.lightapp.multipage.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.closeWindow();
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
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (iLightappInvokerCallback = this.f58728b.get(INSERT_CALENDAR_EVENT)) == null) {
            return;
        }
        if (z) {
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, new JSONObject()));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", LightappConstants.ERRCODE_ACTION_WITHOUT_RESULT);
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
            this.f58728b.put(string, iLightappInvokerCallback);
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
                h();
            } else if (MW_IS_PRELOADED.equals(string)) {
                a(iLightappInvokerCallback, string2);
            } else if (MW_RM_FROM_PRELOAD_POOL.equals(string)) {
                g();
            } else if (MW_GET_LANGBRIDGE_HASH_STAMP.equals(string)) {
                b(context, iLightappInvokerCallback, string2);
            } else if (MW_GET_LANGBRIDGE_SETTINGS.equals(string)) {
                a(context, iLightappInvokerCallback, string2);
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
                public final /* synthetic */ LightAppTakePictureModel f58735a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappJsNativeClient f58736b;

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
                    this.f58736b = this;
                    this.f58735a = lightAppTakePictureModel;
                }

                @Override // com.baidu.apollon.utils.ImageBase64Utils.ImageBase64Listener
                public void onBase64Result(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        LightAppTakePictureModel lightAppTakePictureModel2 = this.f58735a;
                        lightAppTakePictureModel2.cnt.image = str;
                        this.f58736b.a(LightappBusinessClient.METHOD_CALL_CAMERA, 0, lightAppTakePictureModel2.toJson());
                        try {
                            File file = new File(this.f58736b.l);
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
                if (this.m == f58725d) {
                    PhoneContactsMananger.a(this.k.getContext()).a(new PhoneContactsMananger.d(this, contactSelectModel) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ContactSelectModel f58733a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LightappJsNativeClient f58734b;

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
                            this.f58734b = this;
                            this.f58733a = contactSelectModel;
                        }

                        @Override // com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger.d
                        public void a(List<ContactSelectModel.AllContact> list, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, list, i3) == null) {
                                if (this.f58734b.p != null) {
                                    this.f58733a.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), this.f58734b.p));
                                } else {
                                    this.f58733a.cnt.all = list;
                                }
                                if (this.f58734b.o != LightappJsNativeClient.f58726e) {
                                    this.f58734b.a("selectPhonefromAdressBook", 0, this.f58733a.toJson());
                                    return;
                                }
                                LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                                ContactSelectModel contactSelectModel2 = this.f58733a;
                                lightAppContactSelectModelBase64.result = contactSelectModel2.result;
                                ContactSelectModel.Data data2 = contactSelectModel2.cnt;
                                if (data2 != null) {
                                    lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data2).getBytes());
                                }
                                this.f58734b.a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
                            }
                        }
                    });
                    if (this.n > 0) {
                        PhoneContactsMananger.a(this.k.getContext()).a(this.n, false);
                    } else {
                        PhoneContactsMananger.a(this.k.getContext()).a(1000, false);
                    }
                } else if (this.o == f58726e) {
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
            boolean z = ArrayUtils.isEmpty(strArr) || ArrayUtils.isEmpty(iArr);
            switch (i2) {
                case 209:
                    if (z) {
                        b();
                        return;
                    }
                    while (i3 < strArr.length) {
                        if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i3]) && i3 < iArr.length) {
                            int i4 = iArr[i3];
                            if (i4 == 0) {
                                if (PermissionManager.checkCallingPermission(this.k.getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                                    a(this.k.getActivity());
                                } else if (!PermissionManager.checkCallingOrSelfPermission(this.k.getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 210)) {
                                    c();
                                }
                            } else if (i4 == -1) {
                                b();
                            }
                        }
                        i3++;
                    }
                    return;
                case 210:
                    if (z) {
                        c();
                        return;
                    }
                    while (i3 < strArr.length) {
                        if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i3]) && i3 < iArr.length) {
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
                case 211:
                    if (z) {
                        a(str);
                        return;
                    }
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
                case 212:
                    if (!ArrayUtils.isEmpty(iArr) && iArr[0] != 0) {
                        a(this.k.getContext(), this.v, new LightAppNewLocationModel());
                        DXMSdkSAUtils.onEvent(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS_NO_PERMISSION);
                        return;
                    }
                    e();
                    return;
                default:
                    return;
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            ContactManager.getIContactsImpl().pickContactsByContactsContentUri(this.k.getActivity(), 4);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65566, this) == null) || TextUtils.isEmpty(this.u)) {
            return;
        }
        d(this.k.getContext(), this.u, this.t, this.v);
        this.u = null;
        this.v = null;
    }

    private void g(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, this, jSONObject, str) == null) {
            String optString = jSONObject.optString("title");
            if (TextUtils.isEmpty(optString)) {
                LightappUtils.onError(this.f58728b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, "标题不能为空", "#insertCalendarEventFail");
                return;
            }
            Long valueOf = Long.valueOf(jSONObject.optLong("beginTime"));
            Long valueOf2 = Long.valueOf(jSONObject.optLong("endTime"));
            if (valueOf.longValue() >= 0 && valueOf2.longValue() >= 0 && valueOf2.longValue() >= valueOf.longValue()) {
                Intent putExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("title", optString).putExtra("beginTime", valueOf).putExtra("endTime", valueOf2).putExtra("allDay", jSONObject.optBoolean("allDay")).putExtra("eventLocation", jSONObject.optString("eventLocation")).putExtra("description", jSONObject.optString("description")).putExtra("rrule", jSONObject.optString("rrule"));
                if (this.k.getActivity() != null) {
                    try {
                        this.k.getActivity().startActivityForResult(putExtra, 6);
                        return;
                    } catch (ActivityNotFoundException unused) {
                        Toast.makeText(this.k.getActivity(), ResUtils.string(this.k.getActivity(), "insert_calendar_not_available"), 1).show();
                        LightappUtils.onError(this.f58728b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, ResUtils.getString(this.k.getContext(), "insert_calendar_not_available"), LightAppStatEvent.LIGHT_APP_INSERT_CALENDAR_NOT_AVAILABLE);
                        return;
                    }
                }
                return;
            }
            String str2 = valueOf.longValue() < 0 ? "开始时间必须大于零" : "";
            if (valueOf2.longValue() < 0) {
                str2 = str2 + "结束时间必须大于零";
            }
            if (valueOf2.longValue() < valueOf.longValue()) {
                str2 = str2 + "结束时间必须大于开始时间";
            }
            LightappUtils.onError(this.f58728b.get(INSERT_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, str2, "#insertCalendarEventFail");
        }
    }

    private void h(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, this, jSONObject, str) == null) {
            long optLong = jSONObject.optLong("beginTime");
            int i2 = (optLong > 0L ? 1 : (optLong == 0L ? 0 : -1));
            if (i2 < 0) {
                LightappUtils.onError(this.f58728b.get(VIEW_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INVALID_PARAMETER, "时间必须大于零", "#viewCalendarEventFail");
                return;
            }
            if (i2 == 0) {
                optLong = Calendar.getInstance().getTimeInMillis();
            }
            Uri.Builder buildUpon = CalendarContract.CONTENT_URI.buildUpon();
            buildUpon.appendPath("time");
            ContentUris.appendId(buildUpon, optLong);
            Intent data = new Intent("android.intent.action.VIEW").setData(buildUpon.build());
            if (this.k.getActivity() != null) {
                try {
                    this.k.getActivity().startActivity(data);
                } catch (ActivityNotFoundException unused) {
                    LightappUtils.onError(this.f58728b.get(VIEW_CALENDAR_EVENT), str, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, ResUtils.getString(this.k.getContext(), "view_calendar_not_available"), LightAppStatEvent.LIGHT_APP_VIEW_CALENDAR_NOT_AVAILABLE);
                }
            }
        }
    }

    private void d(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, this, context, str, iLightappInvokerCallback, str2) == null) {
            a(METHOD_GET_CURRENT_POSITION, str);
            LightAppNewLocationModel lightAppNewLocationModel = new LightAppNewLocationModel();
            ILocationCallback iLocationCallback = new ILocationCallback(this, iLightappInvokerCallback, lightAppNewLocationModel) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f58740a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightAppNewLocationModel f58741b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappJsNativeClient f58742c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLightappInvokerCallback, lightAppNewLocationModel};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58742c = this;
                    this.f58740a = iLightappInvokerCallback;
                    this.f58741b = lightAppNewLocationModel;
                }

                @Override // com.baidu.wallet.api.ILocationCallback
                public void onReceiveLocation(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        ILightappInvokerCallback iLightappInvokerCallback2 = this.f58740a;
                        if (iLightappInvokerCallback2 instanceof LightappJsClient.LightappInvokerCallbackImpl) {
                            ((LightappJsClient.LightappInvokerCallbackImpl) iLightappInvokerCallback2).addStatics(this.f58742c.s.name());
                        }
                        if (obj != null && (obj instanceof LightAppLocationModel)) {
                            LightAppLocationModel lightAppLocationModel = (LightAppLocationModel) obj;
                            LightAppNewLocationModel lightAppNewLocationModel2 = this.f58741b;
                            lightAppNewLocationModel2.result = 0;
                            LightAppNewLocationModel.Loc loc = lightAppNewLocationModel2.cnt.data;
                            LightAppLocationModel.Coords coords = lightAppLocationModel.coords;
                            loc.latitude = coords.latitude;
                            loc.longitude = coords.longitude;
                            this.f58740a.onResult(0, lightAppNewLocationModel2.toJson());
                            LightAppLocationModel.Coords coords2 = lightAppLocationModel.coords;
                            LocationCache.a(coords2.latitude, coords2.longitude, LocationCache.Coord.BD09LL, this.f58742c.s);
                            return;
                        }
                        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                        data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                        data.des = "定位失败";
                        this.f58740a.onResult(1, lightAppErrorModel.toJson());
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
                    } finally {
                        this.r = true;
                    }
                } catch (Throwable unused) {
                    LogUtil.d("InvokeLocatonLib", "lib reflect fail");
                }
            }
            Method method = this.q;
            if (method != null) {
                this.s = LocationProvider.OWN;
                try {
                    method.invoke(null, context, new InvocationHandler(this, iLocationCallback) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ILocationCallback f58743a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LightappJsNativeClient f58744b;

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
                            this.f58744b = this;
                            this.f58743a = iLocationCallback;
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
                                    this.f58743a.onReceiveLocation(lightAppLocationModel);
                                } else {
                                    this.f58743a.onReceiveLocation(null);
                                }
                                return null;
                            }
                            return invokeLLL.objValue;
                        }
                    });
                    return;
                } catch (Throwable unused2) {
                    iLocationCallback.onReceiveLocation(null);
                    LogUtil.d("InvokeLocatonLib", "lib invoke fail");
                    return;
                }
            }
            this.s = LocationProvider.SYSTEM;
            b(context, str2, lightAppNewLocationModel);
            LogUtil.d("InvokeLocatonLib", "systme location lib invoke");
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, str, str2) == null) {
            LogUtil.logd("method:" + str + "#options=" + str2);
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
                try {
                    intent.putExtra("output", Uri.fromFile(file));
                    this.k.getActivity().startActivityForResult(intent, 3);
                    this.l = file.getAbsolutePath();
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
                LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                data.des = e3.getMessage();
                a(LightappBusinessClient.METHOD_CALL_CAMERA, 1, lightAppTakePictureModel.toJson());
            }
        }
    }

    private void e(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, this, jSONObject, str) == null) {
            this.k.preLoadException(jSONObject.optString("msg", ""));
        }
    }

    private void f(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, this, jSONObject, str) == null) {
            ILightappInvokerCallback iLightappInvokerCallback = this.f58728b.get(SCREEN_CAPTURE_SETTINGS);
            boolean optBoolean = jSONObject.optBoolean("prevent", false);
            if (this.k.getActivity() != null) {
                LightappUtils.runOnUiThread(new Runnable(this, optBoolean) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f58748a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LightappJsNativeClient f58749b;

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
                        this.f58749b = this;
                        this.f58748a = optBoolean;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.f58748a) {
                                BdWalletUtils.addFlagsSecure(this.f58749b.k.getActivity());
                            } else {
                                BdWalletUtils.clearFlagsSecure(this.f58749b.k.getActivity());
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

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65554, this, context, str, iLightappInvokerCallback, str2) == null) {
            a("getDeviceInfo", str);
            LightAppDeviceInfoModel lightAppDeviceInfoModel = new LightAppDeviceInfoModel(0);
            try {
                lightAppDeviceInfoModel.cnt.data.BAIDUCUID = DeviceId.getCUID(context);
            } catch (Exception unused) {
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
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            arrayList.add(Base64Utils.encodeToString(json.getBytes()));
        }
    }

    private void c(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, this, context, str, iLightappInvokerCallback, str2) == null) {
            this.t = iLightappInvokerCallback;
            if (PermissionManager.checkCallingPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                d(context, str, iLightappInvokerCallback, str2);
                return;
            }
            this.u = str;
            this.v = str2;
            BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", this.k.getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, context, str2) { // from class: com.baidu.wallet.lightapp.base.LightappJsNativeClient.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f58737a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f58738b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappJsNativeClient f58739c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58739c = this;
                    this.f58737a = context;
                    this.f58738b = str2;
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        if (!bool.booleanValue()) {
                            this.f58739c.a(this.f58737a, this.f58738b, new LightAppNewLocationModel());
                        } else {
                            PermissionManager.checkCallingOrSelfPermission(this.f58739c.k.getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 212);
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

    private void e(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65567, this, context, str, iLightappInvokerCallback, str2) == null) {
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

    private void c(JSONObject jSONObject, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, this, jSONObject, str) == null) {
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
        if (interceptable == null || interceptable.invokeLL(65564, this, jSONObject, str) == null) {
            LogUtil.d("WEBLOG", jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, this, str, i2, str2) == null) {
            try {
                if (this.f58728b == null || (iLightappInvokerCallback = this.f58728b.get(str)) == null) {
                    return;
                }
                iLightappInvokerCallback.onResult(i2, str2);
                this.f58728b.remove(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                    if (this.m != f58724c && this.m != f58725d) {
                        throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
                    }
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
        if (!(interceptable == null || interceptable.invokeLLL(65555, this, context, str, lightAppNewLocationModel) == null) || context == null || this.t == null) {
            return;
        }
        if (lightAppNewLocationModel == null) {
            lightAppNewLocationModel = new LightAppNewLocationModel();
        }
        LightAppNewLocationModel lightAppNewLocationModel2 = lightAppNewLocationModel;
        ILightappInvokerCallback iLightappInvokerCallback = this.t;
        if (iLightappInvokerCallback instanceof LightappJsClient.LightappInvokerCallbackImpl) {
            ((LightappJsClient.LightappInvokerCallbackImpl) iLightappInvokerCallback).addStatics(LocationProvider.SYSTEM.name());
        }
        LocationManager locationManager = (LocationManager) DxmApplicationContextImpl.getApplicationContext(context).getSystemService("location");
        if (locationManager != null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(CheckUtils.stripUrlParams(str));
            } catch (Exception unused) {
            }
            locationManager.requestSingleUpdate("network", new a(this.t, str, locationManager, arrayList, lightAppNewLocationModel2), (Looper) null);
            return;
        }
        f();
    }

    private void b(Context context, ILightappInvokerCallback iLightappInvokerCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, this, context, iLightappInvokerCallback, str) == null) {
            if (this.k instanceof LightappBrowseActivity) {
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                data.errCode = "10004";
                data.des = "没有找到对应的方法";
                iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                String[] a2 = j.a().a(context);
                a2[0] = this.k.getCellHashStamps();
                jSONObject.put("data", new JSONArray(JsonUtils.toJson(a2)));
                String str2 = this.f58727a;
                LogUtil.i(str2, "端能力返回值 getLangbridgeHashStamp = " + jSONObject.toString());
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
            } catch (Throwable th) {
                th.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str, LightappConstants.ERRCODE_INNER_ERROR, "返回值异常", "#getLangbridgeHashStampFail");
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            ContactSelectModel contactSelectModel = new ContactSelectModel(1);
            ContactSelectModel.Data data = contactSelectModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = PhoneUtils.getApplicationName(this.k.getActivity()) + "没有访问通信录的权限";
            a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
        }
    }

    private void b(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, jSONObject, str) == null) {
            String optString = jSONObject.optString("url", "");
            String optString2 = jSONObject.optString("backup_url", "");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.k.openInNewWebView(optString, optString2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, LightAppNewLocationModel lightAppNewLocationModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, this, context, str, lightAppNewLocationModel) == null) || context == null || this.t == null) {
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
    }

    private void a(Context context, ILightappInvokerCallback iLightappInvokerCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, context, iLightappInvokerCallback, str) == null) {
            LangbridgeSettings a2 = i.a().a(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", JsonUtils.toJson(a2));
                String str2 = this.f58727a;
                LogUtil.i(str2, "端能力返回值 框架配置情况 = " + jSONObject.toString());
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
            } catch (Throwable th) {
                th.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str, LightappConstants.ERRCODE_INNER_ERROR, "返回值异常", "#getLangbridgeSettingsFail");
            }
        }
    }

    private void a(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, jSONObject, str) == null) {
            this.k.historyGo(jSONObject.optInt("index"));
        }
    }

    private void a(ILightappInvokerCallback iLightappInvokerCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, iLightappInvokerCallback, str) == null) {
            if (this.k == null) {
                LightappUtils.onError(iLightappInvokerCallback, str, LightappConstants.ERRCODE_INNER_ERROR, "internal error", "#isPreloadedFail");
            }
            boolean isPreloaded = this.k.isPreloaded();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.KEYS.RET, isPreloaded ? "1" : "0");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
            }
        }
    }
}
