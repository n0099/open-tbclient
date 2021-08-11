package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class LightappJsClient implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LIGHTAPP_JS_NAME = "BLightApp";
    public static final int VIEW_INVISIBLE = 0;
    public static final int VIEW_VISIBLE = 1;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f61301a;

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f61302b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, b> f61303c;

    /* renamed from: d  reason: collision with root package name */
    public LightappBusinessClient f61304d;

    /* renamed from: e  reason: collision with root package name */
    public LightappJsNativeClient f61305e;

    /* renamed from: f  reason: collision with root package name */
    public String f61306f;

    /* renamed from: g  reason: collision with root package name */
    public LightappWebView f61307g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.lightapp.multipage.a f61308h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61309i;

    /* loaded from: classes8.dex */
    public static class LightappInvokerCallbackImpl implements ILightappInvokerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f61310a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f61311b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, b> f61312c;

        public LightappInvokerCallbackImpl(Map<String, b> map, String str, ArrayList<String> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61310a = str;
            this.f61311b = arrayList;
            this.f61312c = map;
        }

        public void addStatics(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (this.f61311b == null) {
                this.f61311b = new ArrayList<>();
            }
            this.f61311b.add(str);
        }

        @Override // com.baidu.wallet.api.ILightappInvokerCallback
        public void onResult(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                b bVar = this.f61312c.get(this.f61310a);
                if (bVar != null) {
                    String str2 = "\"" + LightappUtils.formatJSONForWebViewCallback(str) + "\"";
                    if (i2 == 0) {
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_SUCCESS, this.f61311b);
                        bVar.a(str2);
                    } else if (i2 == 1) {
                        String str3 = "";
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        if (this.f61311b.size() >= 2) {
                            this.f61311b.add(1, str);
                        } else {
                            this.f61311b.add(str);
                        }
                        try {
                            str3 = ((LightAppCommonModel) JsonUtils.fromJson(str, LightAppCommonModel.class)).cnt.errCode;
                        } catch (Exception unused) {
                        }
                        this.f61311b.add(str3);
                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.METHOD_INVOKE_BD_WALLET_NATIVE_FAIL, this.f61311b);
                        bVar.b(str2);
                    }
                }
                this.f61312c.remove(this.f61310a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-369524966, "Lcom/baidu/wallet/lightapp/base/LightappJsClient;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-369524966, "Lcom/baidu/wallet/lightapp/base/LightappJsClient;");
                return;
            }
        }
        f61302b = Pattern.compile("(\\w|\\.|\\$){1,20}");
    }

    public LightappJsClient(com.baidu.wallet.lightapp.multipage.a aVar, LightappWebView lightappWebView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, lightappWebView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61303c = new HashMap<>();
        this.f61309i = false;
        this.f61308h = aVar;
        this.f61307g = lightappWebView;
        this.f61304d = new LightappBusinessClient(aVar);
        this.f61305e = new LightappJsNativeClient(aVar);
    }

    private Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            com.baidu.wallet.lightapp.multipage.a aVar = this.f61308h;
            if (aVar != null) {
                if (aVar.getActivity() != null) {
                    return this.f61308h.getActivity();
                }
                return this.f61308h.getContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    private boolean b(String str, String str2) {
        InterceptResult invokeLL;
        LightappJsNativeClient lightappJsNativeClient;
        Set<String> methodList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || (lightappJsNativeClient = this.f61305e) == null || (methodList = lightappJsNativeClient.getMethodList()) == null || methodList.size() < 1) {
                return false;
            }
            return methodList.contains(str);
        }
        return invokeLL.booleanValue;
    }

    private boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Set<String> methodList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || (methodList = LightAppWrapper.getInstance().getMethodList()) == null || methodList.size() < 1) {
                return false;
            }
            return methodList.contains(str);
        }
        return invokeLL.booleanValue;
    }

    public static void enableJsNameVerify(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f61301a = z;
        }
    }

    public static final boolean isJsFunNameValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            return f61302b.matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    @JavascriptInterface
    public void accessWalletService(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || this.f61304d == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, str);
            jSONObject.put("serviceExtra", str2);
            jSONObject.put("method_name", LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE);
            a(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE, jSONObject.toString(), "", "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @JavascriptInterface
    public void bdLogin(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            a(LightappBusinessClient.METHOD_BD_LOGIN, str, str2, str3);
        }
    }

    @JavascriptInterface
    public void callCamera(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            a(LightappBusinessClient.METHOD_CALL_CAMERA, str, str2, str3);
        }
    }

    @JavascriptInterface
    public void callIDPotos(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            a(LightappBusinessClient.METHOD_CALL_ID_PHOTOS, str, str2, str3);
        }
    }

    @JavascriptInterface
    public void callQRCodeScanner(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            a(LightappBusinessClient.METHOD_CALL_QRCODE_SCANNER, str, str2, str3);
        }
    }

    @JavascriptInterface
    public void callShare(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) {
            a(LightappJsNativeClient.METHOD_CALL_SHARE, str, str2, str3);
        }
    }

    @JavascriptInterface
    public void closeWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a(LightappJsNativeClient.METHOD_CLOSE_WINDOW, "", "", "");
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f61303c.clear();
            this.f61304d = null;
            this.f61305e = null;
            this.f61308h = null;
            this.f61309i = true;
        }
    }

    @JavascriptInterface
    public void detectBankCard(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
            a(LightappBusinessClient.METHOD_DETECT_BANKCARD, str, str2, str3);
        }
    }

    @JavascriptInterface
    public void doBindCard(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("orderInfo", str3);
                jSONObject.put("showDialog", z);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(LightappBusinessClient.METHOD_DO_BIND_CARD, jSONObject.toString(), str, str2);
        }
    }

    @JavascriptInterface
    public void doRnAuth(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("orderInfo", str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(LightappBusinessClient.METHOD_DO_RN_AUTH, jSONObject.toString(), str, str2);
        }
    }

    @JavascriptInterface
    public void dopay(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("orderInfo", str3);
                jSONObject.put("showDialog", z);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(LightappBusinessClient.METHOD_DO_PAY, jSONObject.toString(), str, str2);
        }
    }

    public Set<String> getAllowCalledOnBackgroundMethodlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
            hashSet.add(LightappBusinessClient.MTD_UNREGISTER_H5_GO_BACK);
            hashSet.add("getPayMethod");
            hashSet.add(LightappBusinessClient.METHOD_SET_RN_AUTH_RUSULT);
            hashSet.add("getDeviceInfo");
            if (PermissionManager.checkCallingPermission(a(), "android.permission.ACCESS_FINE_LOCATION")) {
                hashSet.add(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION);
            }
            hashSet.add(LightappJsNativeClient.MW_PRE_LOAD_EXCEPTION);
            hashSet.add(LightappJsNativeClient.MW_NATIVE_LOG);
            hashSet.add(LightappJsNativeClient.MW_IS_PRELOADED);
            hashSet.add(LightappJsNativeClient.MW_RM_FROM_PRELOAD_POOL);
            hashSet.add(LightappJsNativeClient.MW_GET_LANGBRIDGE_HASH_STAMP);
            hashSet.add(LightappJsNativeClient.MW_GET_LANGBRIDGE_SETTINGS);
            hashSet.add(LightappBusinessClient.MTD_GET_OFFLINE_INFO);
            hashSet.add(LightappBusinessClient.MTD_UPLOAD_MSG);
            hashSet.add(LightappBusinessClient.MTD_GET_LOAD_TIME_LINE);
            hashSet.add(LightappBusinessClient.MTD_SEND_TO_SMS);
            hashSet.add(LightappBusinessClient.MTD_GET_PERMISSION_STATE);
            hashSet.add(LightappBusinessClient.MTD_GET_PERMISSIOM_DIALOG_MSG);
            hashSet.add(LightappBusinessClient.METHOD_GET_SUPPORT_LIVENESS);
            hashSet.add("callNativeField");
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    @JavascriptInterface
    public void getBattery(String str, String str2) {
        LightappJsNativeClient lightappJsNativeClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || (lightappJsNativeClient = this.f61305e) == null) {
            return;
        }
        lightappJsNativeClient.getBattery(str, str2);
    }

    @JavascriptInterface
    public void getCurrentPosition(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            a(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, "", str, str2);
        }
    }

    @JavascriptInterface
    public void getDeviceInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, str3) == null) {
            a("getDeviceInfo", str, str2, str3);
        }
    }

    @JavascriptInterface
    public String getGlobalizationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public ILightappInvoker getLightappBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f61304d : (ILightappInvoker) invokeV.objValue;
    }

    @JavascriptInterface
    public void getUserAgent(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, str, str2, str3) == null) {
            a(LightappBusinessClient.METHOD_GET_USER_AGENT, str, str2, str3);
        }
    }

    @JavascriptInterface
    public void initpay(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LightappConstants.INIT_PAY_PARAM_INIT_PARAM, str3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(LightappBusinessClient.METHOD_INIT_PAY, jSONObject.toString(), str, str2);
        }
    }

    @JavascriptInterface
    public void invokeBdWalletNative(String str, String str2, String str3) {
        String optString;
        Set<String> allowCalledOnBackgroundMethodlist;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048597, this, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!isJsFunNameValid(str2) || !isJsFunNameValid(str3)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f61306f);
            arrayList.add(str);
            arrayList.add(str2);
            arrayList.add(str3);
            DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE_INVALID_JS_FUNS, arrayList);
            if (f61301a) {
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str4 = "";
            if (!TextUtils.isEmpty(jSONObject.optString("agentcuid"))) {
                new b(this.f61307g, "window.onBDWalletCallbackProxy && window.onBDWalletCallbackProxy", "").a("\"" + LightappUtils.formatJSONForWebViewCallback(optString) + "\"");
            }
            String str5 = (String) jSONObject.get("method_name");
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            String optString2 = jSONObject.optString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            if (!TextUtils.isEmpty(optString2)) {
                this.f61306f = optString2;
            }
            jSONObject.put(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL, this.f61306f);
            if (this.f61309i) {
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
            arrayList2.add(CheckUtils.stripUrlParams(this.f61306f));
            arrayList2.add(str5);
            arrayList2.add(str4);
            String str6 = "invokeBdWalletNative:" + str5;
            b bVar = new b(this.f61307g, str2, str3);
            if (this.f61303c != null && !this.f61303c.containsKey(str6)) {
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_BDWALLET_NATIVE, arrayList2);
            }
            this.f61303c.put(str6, bVar);
            LightappInvokerCallbackImpl lightappInvokerCallbackImpl = new LightappInvokerCallbackImpl(this.f61303c, str6, arrayList2);
            if (!this.f61308h.isActiveCell() && ((allowCalledOnBackgroundMethodlist = getAllowCalledOnBackgroundMethodlist()) == null || allowCalledOnBackgroundMethodlist.isEmpty() || !allowCalledOnBackgroundMethodlist.contains(str5))) {
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                lightAppErrorModel.cnt.errCode = LightappConstants.ERRCODE_NOT_ALLOWED_BACKGROUND;
                lightAppErrorModel.cnt.des = "多webview框架下该端能力不允许后台调用";
                lightappInvokerCallbackImpl.onResult(1, lightAppErrorModel.toJson());
            } else if (a(str5, str)) {
                if (this.f61304d != null) {
                    this.f61304d.lightappInvoke(a(), jSONObject.toString(), lightappInvokerCallbackImpl);
                }
            } else if (b(str5, str)) {
                if (this.f61305e != null) {
                    this.f61305e.lightappInvoke(a(), jSONObject.toString(), lightappInvokerCallbackImpl);
                }
            } else if (c(str5, str)) {
                DXMSdkSAUtils.onEventWithValues(LightAppWrapper.LIGHT_APP_METHOD_IMPL_BY_APP, Arrays.asList("#" + str5));
                LightAppWrapper.getInstance().lightappInvoke(a(), jSONObject.toString(), lightappInvokerCallbackImpl);
            } else {
                LightAppErrorModel lightAppErrorModel2 = new LightAppErrorModel(1);
                lightAppErrorModel2.cnt.errCode = "10004";
                lightAppErrorModel2.cnt.des = "没有找到对应的方法";
                lightappInvokerCallbackImpl.onResult(1, lightAppErrorModel2.toJson());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onCallCameraPicCallbackLocal() {
        LightappJsNativeClient lightappJsNativeClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (lightappJsNativeClient = this.f61305e) == null) {
            return;
        }
        lightappJsNativeClient.onCallCameraPicCallback();
    }

    public void onContactsSelectedLocal(int i2, String[] strArr, String str) {
        LightappJsNativeClient lightappJsNativeClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048599, this, i2, strArr, str) == null) || (lightappJsNativeClient = this.f61305e) == null) {
            return;
        }
        lightappJsNativeClient.onContactsSelected(this.f61306f, i2, strArr, str);
    }

    public void onInsertCalendarEventDone(boolean z) {
        LightappJsNativeClient lightappJsNativeClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (lightappJsNativeClient = this.f61305e) == null) {
            return;
        }
        lightappJsNativeClient.handleInsertEventDone(z);
    }

    public void onRequestPermissionsResultLocal(int i2, String[] strArr, int[] iArr) {
        LightappJsNativeClient lightappJsNativeClient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048601, this, i2, strArr, iArr) == null) || (lightappJsNativeClient = this.f61305e) == null) {
            return;
        }
        lightappJsNativeClient.onRequestPermissionsResult(this.f61306f, i2, strArr, iArr);
    }

    @JavascriptInterface
    public void selectPhonefromAdressBook(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, str, str2, str3) == null) {
            a("selectPhonefromAdressBook", str, str2, str3);
        }
    }

    @JavascriptInterface
    public String sessionCommand(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, str, str2, str3)) == null) {
            com.baidu.wallet.lightapp.multipage.a aVar = this.f61308h;
            return aVar == null ? "" : aVar.exeSSCommand(str, str2, str3);
        }
        return (String) invokeLLL.objValue;
    }

    public void setUrlLocal(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.f61306f = str;
        }
    }

    @JavascriptInterface
    public void testInvoke() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            LogUtil.i("LightappJsClient", "testInvoke");
            DXMSdkSAUtils.onEvent("testInvoke");
        }
    }

    @JavascriptInterface
    public void getCurrentPosition(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, str2, str3) == null) {
            a(LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, str, str2, str3);
        }
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        LightappBusinessClient lightappBusinessClient;
        Set<String> methodList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || (lightappBusinessClient = this.f61304d) == null || (methodList = lightappBusinessClient.getMethodList()) == null || methodList.size() < 1) {
                return false;
            }
            return methodList.contains(str);
        }
        return invokeLL.booleanValue;
    }

    private void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, this, str, str2, str3, str4) == null) || this.f61304d == null) {
            return;
        }
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
