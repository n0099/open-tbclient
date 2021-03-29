package com.baidu.wallet.lightapp.business;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.DeviceId;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.statistics.CustomerService;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.Crypto;
import com.baidu.apollon.utils.EncodeUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.mobstat.Config;
import com.baidu.rtc.SdpPrefer;
import com.baidu.searchbox.bddownload.core.breakpoint.sqllite.BreakpointSQLiteKey;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.audio.AudioRecorder;
import com.baidu.wallet.base.audio.AudioVolume;
import com.baidu.wallet.base.controllers.IdCardDetectionController;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.DangerousPermissionUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.SecurityUtils;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.lightapp.base.JavascriptInterfaceManager;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger;
import com.baidu.wallet.lightapp.base.datamodel.LightAppContactSelectModelBase64;
import com.baidu.wallet.lightapp.base.datamodel.LightAppErrorModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppInfoModel;
import com.baidu.wallet.lightapp.base.datamodel.LightAppTakePictureModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCallIDPhotoModel;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCallQRCodeScannerModel;
import com.baidu.wallet.lightapp.business.datamodel.LightAppCommonModel;
import com.baidu.wallet.lightapp.business.datamodel.LightAppDetectBankcardModel;
import com.baidu.wallet.lightapp.business.datamodel.LightAppUserAgentModel;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.ImageBase64Utils;
import com.baidu.wallet.utils.NetUtils;
import com.baidu.wallet.utils.StringUtil;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.security.AccessControlException;
import java.security.DigestException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes5.dex */
public class LightappBusinessClient implements ILightappInvoker {
    public static int A = 1;
    public static final String CALL_NATIVE_VOICE = "callNativeVoice";
    public static final String CANCEL_ACTION = "取消";
    public static final int CONTACTS_REQUESTCODE = 4;
    public static final int FIXED_CONTACT_SIZE = 1000;
    public static final int FIXED_IMAGE_WIDTH = 640;
    public static final String H5BanlanceCallback = "H5Balance";
    public static int JPEG_QUALITY = 70;
    public static final int JS_CALL_CAMERA = 3;
    public static final int JS_CALL_SELECT_ADDRESS_BOOK = 3;
    public static final int JS_DOPAY = 2;
    public static final int JS_INITPAY = 1;
    public static final String KeyH5CallTime = "H5CallTime";
    public static final String METHOD_ACCESS_WALLET_SERVICE = "accessWalletService";
    public static final String METHOD_BD_LOGIN = "bdLogin";
    public static final String METHOD_CALL_CAMERA = "callCamera";
    public static final String METHOD_CALL_ID_PHOTOS = "callIDPotos";
    public static final String METHOD_CALL_QRCODE_SCANNER = "callQRCodeScanner";
    public static final String METHOD_DETECT_BANKCARD = "detectBankCard";
    public static final String METHOD_DETECT_LIVENESS = "faceRegister";
    public static final String METHOD_DO_BIND_CARD = "doBindCard";
    public static final String METHOD_DO_PAY = "dopay";
    public static final String METHOD_DO_RN_AUTH = "doRnAuth";
    public static final String METHOD_GET_SUPPORT_LIVENESS = "getSupportLiveness";
    public static final String METHOD_GET_USER_AGENT = "getUserAgent";
    public static final String METHOD_IDENTIFY_AUTH = "identifyAuth";
    public static final String METHOD_INIT_PAY = "initpay";
    public static final String METHOD_POST_EVENT = "postEvent";
    public static final String METHOD_SET_RN_AUTH_RUSULT = "setRnAuthResult";
    public static final String MTD_BINDCARD_INDEPENDENT = "bindCardIndependent";
    public static final String MTD_BINDCARD_INITIATIVE = "bindCardInitiative";
    public static final String MTD_CALLPHONEINFO = "callPhoneInfo";
    public static final String MTD_CALL_NATIVE_PHOTO = "callNativePhoto";
    public static final String MTD_CUSTOMER_SERVICE = "customerService";
    public static final String MTD_DECRYPT = "decrypt";
    public static final String MTD_DIGEST = "digest";
    public static final String MTD_ENCRYPT = "encrypt";
    public static final String MTD_END_AUDIO_RECORD = "endRecording";
    public static final String MTD_GET_LOAD_TIME_LINE = "getLoadTimeLine";
    public static final String MTD_GET_OFFLINE_INFO = "getOfflineCacheInfo";
    public static final String MTD_GET_PERMISSION_STATE = "getPermissionState";
    public static final String MTD_GET_SUPPORT_LIST = "getSupportedMethodList";
    public static final String MTD_GO_TO_APP_SETTING = "goToAppSetting";
    public static final String MTD_H5GOBCK = "onBDWalletPageGoBack";
    public static final String MTD_LIST_MY_BANK_CARD = "listMyBankCard";
    public static final String MTD_OPEN_IN_BROWSER = "openInBrowser";
    public static final String MTD_PRECASHIER_GET_DEFAULT_PAY_METHOD = "getPayMethod";
    public static final String MTD_PRECASHIER_MODIFY_PAY_METHOD = "changePayMethod";
    public static final String MTD_PRECASHIER_ORDER_PAY_METHOD = "preOrderPay";
    public static final String MTD_SELECT_PHONE_FROM_ADRESSBOOK = "selectPhonefromAdressBook";
    public static final String MTD_SEND_TO_SMS = "sendToSMS";
    public static final String MTD_SETMENU = "setMenu";
    public static final String MTD_SETTITLE = "setTitle";
    public static final String MTD_SET_FULLSCREEN = "setFullScreen";
    public static final String MTD_START_AUDIO_RECORD = "startRecording";
    public static final String MTD_STATEVENT = "doEvent";
    public static final String MTD_UPLOAD_MSG = "uploadMsg";
    public static final int REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE = 245;
    public static final int REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_SENSE = 246;
    public static final int REQUEST_PERMISSION_RECORDAUDIO = 244;
    public static final int REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK = 243;
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_INNER_ERROR = 3;
    public static final int RESULT_LOAD_IMAGE = 5;
    public static final int RESULT_NO_PERMISSION = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final String ROOT = "isBreak";
    public static final long SVC_ID_H5_BALANCE = 10002;
    public static final long SVC_ID_H5_CASHBACK = 10007;
    public static final long SVC_ID_H5_CHARGE = 10008;
    public static final long SVC_ID_H5_CHECKPWD = 10013;
    public static final long SVC_ID_H5_COUPON = 10004;
    public static final long SVC_ID_H5_HOMEPAGE = 10001;
    public static final long SVC_ID_H5_MYBANKCARD = 10005;
    public static final long SVC_ID_H5_PAY_SET = 10014;
    public static final long SVC_ID_H5_PWD_SET = 10015;
    public static final long SVC_ID_H5_QRGEN = 10011;
    public static final long SVC_ID_H5_SCANQR = 10010;
    public static final long SVC_ID_H5_SECURITCENTER = 10006;
    public static final long SVC_ID_H5_TRANSERECORD = 10003;
    public static final long SVC_ID_H5_TRANSFER = 10009;
    public static final String WCP = "H5_PWD_WCP";

    /* renamed from: b  reason: collision with root package name */
    public static int f24982b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f24983c = 1;
    public static int q = -1;
    public static int r = -1;
    public static int s = -1;
    public static String t = null;
    public static int u = 1;
    public static int v = 2;
    public com.baidu.wallet.lightapp.multipage.a B;
    public HandlerThread D;
    public Handler E;
    public String G;

    /* renamed from: e  reason: collision with root package name */
    public Class<?> f24986e;

    /* renamed from: f  reason: collision with root package name */
    public Method f24987f;

    /* renamed from: g  reason: collision with root package name */
    public Class<?> f24988g;

    /* renamed from: h  reason: collision with root package name */
    public Class<?> f24989h;
    public Method i;
    public Class<?> j;
    public Class<?> k;
    public Method l;
    public Class<?> m;
    public String n;
    public ILightappInvokerCallback o;
    public String p;

    /* renamed from: a  reason: collision with root package name */
    public String f24984a = LightappBusinessClient.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public boolean f24985d = false;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public final HashMap<String, ILightappInvokerCallback> z = new HashMap<>();
    public ILightappInvokerCallback C = null;
    public HashMap<String, b> F = null;

    /* renamed from: com.baidu.wallet.lightapp.business.LightappBusinessClient$12  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass12 implements RouterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ILightappInvokerCallback f24996a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f24997b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f24998c;

        public AnonymousClass12(ILightappInvokerCallback iLightappInvokerCallback, String str, Context context) {
            this.f24996a = iLightappInvokerCallback;
            this.f24997b = str;
            this.f24998c = context;
        }

        @Override // com.baidu.wallet.router.RouterCallback
        public void onResult(int i, HashMap hashMap) {
            Bundle bundle;
            if (i == 0) {
                if (hashMap == null || hashMap.size() <= 0 || (bundle = (Bundle) hashMap.get("result")) == null) {
                    return;
                }
                bundle.getInt("step");
                final String string = bundle.getString("pic1");
                final String string2 = bundle.getString("pic2");
                final LightAppCallIDPhotoModel lightAppCallIDPhotoModel = new LightAppCallIDPhotoModel(0);
                final ImageBase64Utils imageBase64Utils = ImageBase64Utils.getInstance();
                imageBase64Utils.getImageBase64(string, 640, new ImageBase64Utils.ImageBase64Listener() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.12.1
                    @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                    public void onBase64Result(String str) {
                        lightAppCallIDPhotoModel.cnt.front = str;
                        imageBase64Utils.getImageBase64(string2, 640, new ImageBase64Utils.ImageBase64Listener() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.12.1.1
                            @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                            public void onBase64Result(String str2) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                LightAppCallIDPhotoModel lightAppCallIDPhotoModel2 = lightAppCallIDPhotoModel;
                                lightAppCallIDPhotoModel2.cnt.back = str2;
                                AnonymousClass12.this.f24996a.onResult(0, lightAppCallIDPhotoModel2.toJson());
                                try {
                                    if (string != null) {
                                        File file = new File(string);
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                try {
                                    if (string2 != null) {
                                        File file2 = new File(string2);
                                        if (file2.exists()) {
                                            file2.delete();
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                            }
                        });
                    }
                });
            } else if (i == 1) {
                if (hashMap == null || hashMap.size() <= 0) {
                    return;
                }
                int intValue = ((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue();
                String str = (String) hashMap.get("errMsg");
                if (intValue == -1) {
                    LightappUtils.onError(this.f24996a, this.f24997b, LightappConstants.ERRCODE_NO_PERMISSION, LightappBusinessClient.this.a(this.f24998c, "访问相机的权限"), "#callIDPotosFail");
                } else if (-2 == intValue) {
                    LightappUtils.onError(this.f24996a, this.f24997b, LightappConstants.ERRCODE_CANCEL, "取消", "#callIDPotosFail");
                }
            } else {
                String str2 = (String) hashMap.get("errorMsg");
                ILightappInvokerCallback iLightappInvokerCallback = this.f24996a;
                String str3 = this.f24997b;
                String num = Integer.toString(i);
                if (!TextUtils.isEmpty(str2)) {
                    str2 = LightappConstants.ROUTER_INVOKE_FAIL;
                }
                LightappUtils.onError(iLightappInvokerCallback, str3, num, str2, "#callIDPotosFail");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f25080a;

        /* renamed from: b  reason: collision with root package name */
        public int f25081b;

        /* renamed from: c  reason: collision with root package name */
        public int f25082c;

        /* renamed from: d  reason: collision with root package name */
        public int f25083d;

        /* renamed from: e  reason: collision with root package name */
        public ILightappInvokerCallback f25084e;

        /* renamed from: f  reason: collision with root package name */
        public String f25085f;

        /* renamed from: g  reason: collision with root package name */
        public String f25086g;

        /* renamed from: h  reason: collision with root package name */
        public String f25087h;

        public a() {
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f25088a;

        /* renamed from: b  reason: collision with root package name */
        public String f25089b;

        /* renamed from: c  reason: collision with root package name */
        public ILightappInvokerCallback f25090c;

        /* renamed from: d  reason: collision with root package name */
        public String f25091d;

        public b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
            this.f25088a = context;
            this.f25089b = str;
            this.f25090c = iLightappInvokerCallback;
            this.f25091d = str2;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        public ILightappInvokerCallback f25093a;

        public c(ILightappInvokerCallback iLightappInvokerCallback) {
            this.f25093a = iLightappInvokerCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (this.f25093a != null) {
                if ("onResult".equals(method.getName())) {
                    if (objArr != null && objArr.length >= 2) {
                        this.f25093a.onResult(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                    }
                    return null;
                }
                return method.invoke(this.f25093a, objArr);
            }
            return null;
        }
    }

    public LightappBusinessClient(com.baidu.wallet.lightapp.multipage.a aVar) {
        this.E = null;
        this.B = aVar;
        HandlerThread handlerThread = new HandlerThread("LangbridgeThread");
        this.D = handlerThread;
        handlerThread.start();
        this.E = new Handler(this.D.getLooper()) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (1 == i) {
                    LightappBusinessClient.this.a((a) message.obj);
                } else if (2 == i) {
                    LightappBusinessClient.this.b((a) message.obj);
                }
            }
        };
    }

    private long a(long j) {
        if (SVC_ID_H5_HOMEPAGE == j) {
            return 16384L;
        }
        if (SVC_ID_H5_BALANCE == j) {
            return 32L;
        }
        if (SVC_ID_H5_TRANSERECORD == j) {
            return 16L;
        }
        if (SVC_ID_H5_COUPON == j) {
            return 64L;
        }
        if (SVC_ID_H5_MYBANKCARD == j) {
            return 4L;
        }
        if (SVC_ID_H5_SECURITCENTER == j) {
            return 8L;
        }
        if (SVC_ID_H5_CASHBACK == j) {
            return 8192L;
        }
        if (SVC_ID_H5_CHARGE == j) {
            return 1L;
        }
        if (SVC_ID_H5_TRANSFER == j) {
            return 2L;
        }
        if (SVC_ID_H5_SCANQR == j) {
            return 32768L;
        }
        if (SVC_ID_H5_QRGEN == j) {
            return 512L;
        }
        if (SVC_ID_H5_CHECKPWD == j) {
            return WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_CHECK;
        }
        if (SVC_ID_H5_PAY_SET == j) {
            return WalletServiceBeanConst.SERVICE_ID_WALLET_PAY_SET;
        }
        if (SVC_ID_H5_PWD_SET == j) {
            return WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_SET;
        }
        return -1L;
    }

    private void h(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        try {
            HashMap hashMap = (HashMap) JsonUtils.fromJson(new JSONObject(str).getString("dxmPayLiveness"), HashMap.class);
            PayStatisticsUtil.onEventWithValue("#identifyAuth", CheckUtils.stripUrlParams(str2));
            if (LocalRouter.getInstance(context).isProviderExisted("livenessidentifyauth")) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("livenessidentifyauth").action("livenessidentifyauth").data(hashMap), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.7
                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i, HashMap hashMap2) {
                        if (i != 0) {
                            if (i == 5) {
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("provider", "livenessidentifyauth");
                                hashMap3.put("action", "livenessidentifyauth");
                                DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                                PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                                return;
                            }
                            LightappUtils.onError(iLightappInvokerCallback, str2, i + "", PhoneUtils.getApplicationName(context) + ((String) hashMap2.get("errorMsg")), "#identifyAuthFail");
                        } else if (hashMap2 != null) {
                            Object obj = hashMap2.get("value");
                            if (!(obj instanceof String) || TextUtils.isEmpty((String) obj)) {
                                return;
                            }
                            try {
                                LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(0);
                                lightAppCommonModel.cnt.errCode = String.valueOf(0);
                                lightAppCommonModel.cnt.des = "成功";
                                lightAppCommonModel.cnt.data = (HashMap) JsonUtils.fromJson((String) obj, HashMap.class);
                                iLightappInvokerCallback.onResult(0, lightAppCommonModel.toJson());
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                                LightappUtils.onError(iLightappInvokerCallback, str2, i + "", PhoneUtils.getApplicationName(context) + ((String) hashMap2.get("errorMsg")), "#identifyAuthFail");
                            }
                        }
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void i(final Context context, final String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        Set<String> methodList = LightAppWrapper.getInstance().getMethodList();
        if (methodList != null && methodList.contains("callNativeVoice")) {
            LightAppWrapper.getInstance().lightappInvoke(context, str, iLightappInvokerCallback);
        } else {
            WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.8
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i, String str3) {
                    LightappUtils.onError(iLightappInvokerCallback, str2, String.valueOf(101), "请重新登录!", "#callNativeVoiceFail");
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i, String str3) {
                    if (!LightappBusinessClient.this.w) {
                        try {
                            LightappBusinessClient.this.f24986e = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                            LightappBusinessClient.this.f24988g = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                            LightappBusinessClient.this.f24987f = LightappBusinessClient.this.f24986e.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, Context.class, String.class, Boolean.TYPE, LightappBusinessClient.this.f24988g);
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                    if (LightappBusinessClient.this.f24986e != null && LightappBusinessClient.this.f24988g != null && LightappBusinessClient.this.f24987f != null) {
                        try {
                            Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{LightappBusinessClient.this.f24988g}, new c(iLightappInvokerCallback));
                            boolean equals = "ONLINE".equals(DebugConfig.getInstance().getEnvironment());
                            JSONObject jSONObject = new JSONObject(str);
                            jSONObject.put("stoken", WalletLoginHelper.getInstance().getLoginStoken());
                            LightappBusinessClient.this.f24987f.invoke(null, context, jSONObject.toString(), Boolean.valueOf(equals), newProxyInstance);
                            return;
                        } catch (Throwable unused) {
                            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INNER_ERROR, "reflect callNativeVoice fail!", "#callNativeVoiceFail");
                            return;
                        }
                    }
                    LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                    LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                    data.errCode = "10004";
                    data.des = "没有找到对应的方法";
                    iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
                }
            }));
        }
    }

    private void j(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (CheckUtils.isFastDoubleClick()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = "10004";
            data.des = "系统版本不支持";
            iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
        } else if (PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) && PermissionManager.checkCallingPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            k(context, str, iLightappInvokerCallback, str2);
        } else {
            BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.9
                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.B.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 245);
                    } else {
                        LightappBusinessClient.this.onRequestPermissionsResult(str2, 245, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1, -1});
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
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, CONST_STR, INVOKE, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, IPUT, MOVE_EXCEPTION] complete} */
    private void k(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (!this.x) {
            try {
                this.f24989h = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessManager");
                Class<?> cls = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessCallback");
                this.j = cls;
                this.i = this.f24989h.getDeclaredMethod("startDetact", Context.class, String.class, cls);
            } finally {
                try {
                } finally {
                }
            }
        }
        if (this.f24989h != null && this.j != null && this.i != null) {
            try {
                this.i.invoke(null, context, str, Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.j}, new c(iLightappInvokerCallback)));
                return;
            } catch (Throwable unused) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INNER_ERROR, "reflect faceliveness fail!", "#callFaceLivenessFail");
                return;
            }
        }
        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
        data.errCode = "10004";
        data.des = "没有找到对应的方法";
        iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
    }

    private void l(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) && PermissionManager.checkCallingPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            m(context, str, iLightappInvokerCallback, str2);
        } else {
            PermissionManager.checkCallingOrSelfPermission(getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 246);
        }
    }

    private void m(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (d()) {
            try {
                this.l.invoke(null, context, str, Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.m}, new c(iLightappInvokerCallback)));
                return;
            } catch (Throwable unused) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INNER_ERROR, "reflect senseliveness fail!", "#callSenseLivenessFail");
                return;
            }
        }
        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
        data.errCode = "10004";
        data.des = "没有找到对应的方法";
        iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
    }

    private void n(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (iLightappInvokerCallback == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValue("#digest", CheckUtils.stripUrlParams(str2));
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            byte[] bArr = null;
            String optString = jSONObject.optString("algorithm", null);
            if (optString != null) {
                String optString2 = jSONObject.optString("data", null);
                if (optString2 != null) {
                    try {
                        bArr = Base64.decode(optString2, 2);
                        if (bArr == null || bArr.length == 0) {
                            throw new IllegalArgumentException("传入的base64数据不正确");
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                if (Pattern.compile("MD5|SHA-(1|224|256|384|512)").matcher(optString).matches()) {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(optString);
                        if (bArr != null) {
                            messageDigest.update(bArr);
                        }
                        hashMap.put("data", Base64.encodeToString(StringUtil.arrayToString(messageDigest.digest(), 0, 9999).getBytes(), 2));
                        iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult((Map<String, Object>) hashMap, true));
                        return;
                    } catch (Exception unused) {
                        throw new DigestException("make digest of data error");
                    }
                }
                throw new NoSuchAlgorithmException("Supported algorithms: MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA- 512." + optString + " is not supported yet");
            }
            throw new InvalidParameterException("no message digest algorithm key [algorithm]");
        } catch (Exception e3) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e3.getLocalizedMessage(), "#digestFail");
        }
    }

    private void o(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        a("selectPhonefromAdressBook", str);
        try {
            try {
                String optString = new JSONObject(str).optString("key", null);
                t = optString;
                if (optString != null && optString.trim().length() == 0) {
                    throw new InvalidParameterException("加密密钥格式非法");
                }
                q = LightappUtils.parseJsonInt(str, "type");
                r = LightappUtils.parseJsonInt(str, "maxNum");
                s = LightappUtils.parseJsonInt(str, "base64");
                if (q != u && q != v) {
                    throw new InvalidParameterException("参数非法");
                }
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(CheckUtils.stripUrlParams(str2));
                } catch (Exception unused) {
                }
                arrayList.add(q + "");
                PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_SELECT_PHONE_FROM_ADDRESSBOOK, arrayList);
                if (PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
                    if (this.B != null) {
                        this.B.selectPhoneFromAddressBook();
                        return;
                    }
                    return;
                }
                BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, getActivity(), new String[]{"android.permission.READ_CONTACTS"}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.10
                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        if (bool.booleanValue()) {
                            if (PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK)) {
                                return;
                            }
                            LightappBusinessClient.this.a(str2);
                            return;
                        }
                        LightappBusinessClient.this.onRequestPermissionsResult("", LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, new String[]{"android.permission.READ_CONTACTS"}, new int[]{-1});
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isShow(String str3, Boolean bool) {
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void requestResult(String str3, Boolean bool) {
                    }
                });
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

    private void p(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        PayStatisticsUtil.onEventWithValue("#setTitle", CheckUtils.stripUrlParams(str2));
        if (this.B == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.B.setTitlesInMainThread(jSONObject.optString("mainTitle", null), jSONObject.optString("subTitle", null), "1".equals(jSONObject.optString("scaleMainTitle", "1")));
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, "");
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#setTitleFail");
        }
    }

    private void q(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        PayStatisticsUtil.onEventWithValue("#setFullScreen", CheckUtils.stripUrlParams(str2));
        if (this.B == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject fullScreenInMainThread = this.B.setFullScreenInMainThread(TextUtils.equals("1", jSONObject.optString("fullScreen", "")), TextUtils.equals("1", jSONObject.optString("isHideTitle", "")), TextUtils.equals("1", jSONObject.optString("isHideHost", "")), TextUtils.equals("1", jSONObject.optString("actionIconWhite", "")), jSONObject.optString("actionBarColor", null), jSONObject.optString("titleColor", null));
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, fullScreenInMainThread));
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#setFullScreenFail");
        }
    }

    private void r(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("eventName", null);
            if (TextUtils.isEmpty(optString)) {
                PayStatisticsUtil.onEventWithValue("#doEventFail", CheckUtils.stripUrlParams(str2));
                return;
            }
            String optString2 = jSONObject.optString("eventValues", null);
            if (TextUtils.isEmpty(optString2)) {
                PayStatisticsUtil.onEvent(optString);
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(optString2);
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                PayStatisticsUtil.onEventWithValues(optString, arrayList);
                arrayList.add(0, optString);
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_DO_EVENT_KEY, arrayList);
            } catch (Exception unused) {
                DXMSdkSAUtils.onEventWithValues(optString, Arrays.asList(optString2));
                PayStatisticsUtil.onEventWithValue(optString, optString2);
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#doEventFail");
        }
    }

    private void s(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        PayStatisticsUtil.onEventWithValue("#openInBrowser", CheckUtils.stripUrlParams(str2));
        try {
            if (!TextUtils.isEmpty(str2)) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                LogUtil.i(this.f24984a, "Open in Browser Success");
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, "");
                }
            } else if (iLightappInvokerCallback != null) {
                LogUtil.i(this.f24984a, "Open in Browser fail");
                iLightappInvokerCallback.onResult(1, "url为空");
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#openInBrowserFail");
        }
    }

    private void t(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        PayStatisticsUtil.onEventWithValue("#setMenu", CheckUtils.stripUrlParams(str2));
        if (this.B == null) {
            return;
        }
        try {
            this.B.setMenuInMainThread(new JSONObject(str).getJSONArray("menu_list"));
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, "");
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#setMenuFail");
        }
    }

    private void u(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        PayStatisticsUtil.onEventWithValue("#onBDWalletPageGoBack", CheckUtils.stripUrlParams(str2));
        setH5BackCb(iLightappInvokerCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i;
        JSONObject jSONObject;
        LightappBusinessClient lightappBusinessClient;
        Context context2;
        if (iLightappInvokerCallback == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValue("#callPhoneInfo", CheckUtils.stripUrlParams(str2));
        String str3 = null;
        JSONObject jSONObject2 = new JSONObject();
        boolean z = false;
        try {
            jSONObject = new JSONObject(str);
            if (jSONObject.has("all") && "true".equals(jSONObject.getString("all"))) {
                String[] strArr = {"screenWidth", "screenHeight", "walletUserAgent", "cuid", "BAIDUCUID", "location", "localIp", "wifi", WCP, ROOT};
                JSONObject jSONObject3 = new JSONObject();
                for (int i2 = 0; i2 < 10; i2++) {
                    jSONObject3.put(strArr[i2], "1");
                }
                context2 = context;
                jSONObject = jSONObject3;
                lightappBusinessClient = this;
            } else {
                lightappBusinessClient = this;
                context2 = context;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            str3 = lightappBusinessClient.a(context2, jSONObject);
            i = 0;
        } catch (Exception e3) {
            e = e3;
            try {
                jSONObject2.put("data", Base64Utils.encodeToString(new JSONObject().toString().getBytes()));
                jSONObject2.put(RouterCallback.KEY_ERROR_CODE, 1);
                jSONObject2.put("des", "exception." + e.getMessage());
                str3 = LightappUtils.assembleResult(1, jSONObject2);
                i = 1;
            } catch (Exception unused) {
                i = 1;
                z = true;
            }
            if (z) {
            }
            iLightappInvokerCallback.onResult(i, str3);
            if (i == 0) {
            }
        }
        if (z) {
            str3 = LightappUtils.assembleResult(1, jSONObject2);
        }
        iLightappInvokerCallback.onResult(i, str3);
        if (i == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(CheckUtils.stripUrlParams(str2));
            arrayList.add(str3);
            PayStatisticsUtil.onEventWithValues("#callPhoneInfoFail", arrayList);
        }
    }

    private void w(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        PayStatisticsUtil.onEventWithValue("#callNativePhoto", CheckUtils.stripUrlParams(str2));
        this.p = str;
        if (!PermissionManager.checkCallingPermission(this.B.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
            BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, this.B.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.16
                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    if (bool.booleanValue()) {
                        PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.B.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
                    } else {
                        LightappBusinessClient.this.onRequestPermissionsResult(str2, 4, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new int[]{-1});
                    }
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isShow(String str3, Boolean bool) {
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void requestResult(String str3, Boolean bool) {
                }
            });
        } else {
            this.B.loadAlubm(str);
        }
    }

    private void x(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        PayStatisticsUtil.onEventWithValue("#sendToSMS", CheckUtils.stripUrlParams(str2));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("telephone_num");
            String optString2 = jSONObject.optString("sms_message");
            if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("smsto:" + optString));
                intent.putExtra("sms_body", optString2);
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                } else {
                    LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, "intent invalid", "#sendToSMSFail");
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate options", "#sendToSMSFail");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:2|3)|(6:8|9|10|11|12|(2:14|15)(1:17))|22|9|10|11|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
        r4.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contacts", PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS"));
            jSONObject.put("location", PermissionManager.checkCallingPermission(context, "android.permission.ACCESS_FINE_LOCATION"));
            jSONObject.put(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA, PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
            jSONObject.put("audio", PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!PermissionManager.checkCallingPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && !PermissionManager.checkCallingPermission(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            z = false;
            jSONObject.put("storage", z);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(RouterCallback.KEY_ERROR_CODE, 0);
            jSONObject2.put("des", "成功");
            jSONObject2.put("permissions", jSONObject);
            if (iLightappInvokerCallback == null) {
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject2));
                return;
            }
            return;
        }
        z = true;
        jSONObject.put("storage", z);
        JSONObject jSONObject22 = new JSONObject();
        jSONObject22.put(RouterCallback.KEY_ERROR_CODE, 0);
        jSONObject22.put("des", "成功");
        jSONObject22.put("permissions", jSONObject);
        if (iLightappInvokerCallback == null) {
        }
    }

    private void z(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        LogUtil.i("WebViewCacheManager", "uploadMsg, options: " + str);
        PayStatisticsUtil.onEventWithValue("#uploadMsg", CheckUtils.stripUrlParams(str2));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString("httpMethod", "GET");
            String optString3 = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (optString.equals("first_usable")) {
                    linkedHashMap.put("url", optString3);
                    linkedHashMap.put("beforeFetchTime", jSONObject.optString("beforeFetchTime"));
                    linkedHashMap.put("navigateStartTime", jSONObject.optString("navigateStartTime"));
                    linkedHashMap.put("sslConnectTime", jSONObject.optString("sslConnectTime"));
                    linkedHashMap.put("connectTime", jSONObject.optString("connectTime"));
                    linkedHashMap.put("responseReceiveTime", jSONObject.optString("responseReceiveTime"));
                    linkedHashMap.put("responseTotalTime", jSONObject.optString("responseTotalTime"));
                    linkedHashMap.put("onLoadTime", jSONObject.optString("onLoadTime"));
                    linkedHashMap.put(Config.LAUNCH_REFERER, jSONObject.optString(Config.LAUNCH_REFERER));
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(optString3).toString());
                    Tracker.sendPerformanceInfoToSensors(optString, linkedHashMap, context);
                } else if (optString.equals("window_exception") || optString.equals("cross_origin_exception")) {
                    linkedHashMap.put("url", optString3);
                    linkedHashMap.put("message", jSONObject.optString("message"));
                    linkedHashMap.put(Config.LAUNCH_REFERER, jSONObject.optString(Config.LAUNCH_REFERER));
                    linkedHashMap.put("uuid", jSONObject.optString("uuid"));
                    linkedHashMap.put("stack", jSONObject.optString("stack"));
                    linkedHashMap.put(BreakpointSQLiteKey.FILENAME, jSONObject.optString(BreakpointSQLiteKey.FILENAME));
                    linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(optString3).toString());
                    Tracker.send(optString, linkedHashMap, context, optString2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#uploadMsgFail");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042 A[Catch: Exception -> 0x0096, TRY_ENTER, TryCatch #3 {Exception -> 0x0096, blocks: (B:20:0x0030, B:23:0x0042, B:25:0x0046, B:27:0x0050, B:29:0x0054, B:33:0x006e, B:34:0x007f), top: B:44:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046 A[Catch: Exception -> 0x0096, TryCatch #3 {Exception -> 0x0096, blocks: (B:20:0x0030, B:23:0x0042, B:25:0x0046, B:27:0x0050, B:29:0x0054, B:33:0x006e, B:34:0x007f), top: B:44:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void accessWalletService(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        String str4;
        long parseLong;
        JSONObject jSONObject;
        PayStatisticsUtil.onEventWithValue("#accessWalletService", CheckUtils.stripUrlParams(str2));
        try {
            jSONObject = new JSONObject(str);
            try {
                str3 = jSONObject.getString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
            } catch (Exception e2) {
                e2.printStackTrace();
                str3 = "";
            }
        } catch (Exception e3) {
            e = e3;
            str3 = "";
        }
        try {
            try {
                str4 = jSONObject.getString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_EXTRA);
            } catch (Exception e4) {
                try {
                    e4.printStackTrace();
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    str4 = "";
                    parseLong = Long.parseLong(str3);
                    if (!a(METHOD_ACCESS_WALLET_SERVICE, parseLong)) {
                    }
                }
                str4 = "";
                parseLong = Long.parseLong(str3);
                if (!a(METHOD_ACCESS_WALLET_SERVICE, parseLong)) {
                }
            }
            parseLong = Long.parseLong(str3);
            if (!a(METHOD_ACCESS_WALLET_SERVICE, parseLong)) {
                LightappUtils.onError(iLightappInvokerCallback, str2, "10004", "没有找到对应的方法", "accessWalletServiceFail");
                return;
            }
            long a2 = a(parseLong);
            if (-1 == a2) {
                LightappUtils.onError(iLightappInvokerCallback, str2, "10004", "没有找到对应的方法", "accessWalletServiceFail");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(CheckUtils.stripUrlParams(str2));
            arrayList.add(str);
            PayStatisticsUtil.onEventWithValues("#accessWalletService", arrayList);
            if (iLightappInvokerCallback != null && 32 == a2) {
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                eventBus.postStickyEvent(new EventBus.Event(H5BanlanceCallback, iLightappInvokerCallback));
            }
            BaiduWalletServiceController baiduWalletServiceController = BaiduWalletServiceController.getInstance();
            baiduWalletServiceController.gotoWalletService(context, a2 + "", str4, iLightappInvokerCallback);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void bdLogin(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        String str3;
        PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_BD_LOGIN, CheckUtils.stripUrlParams(str2));
        try {
            str3 = new JSONObject(str).optString("extra_param");
        } catch (JSONException unused) {
            str3 = "";
        }
        WalletLoginHelper.getInstance().onlyLogin(new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.22
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str4) {
                LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i), str4, "#bdLoginFail");
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str4) {
                iLightappInvokerCallback.onResult(0, "0");
            }
        }), str3);
    }

    public void callCamera(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        int i;
        a(METHOD_CALL_CAMERA, str);
        int parseJsonInt = LightappUtils.parseJsonInt(str, "type");
        ArrayList arrayList = new ArrayList();
        arrayList.add(CheckUtils.stripUrlParams(str2));
        arrayList.add("" + parseJsonInt);
        PayStatisticsUtil.onEventWithValues("#callCamera", arrayList);
        if (1 == parseJsonInt) {
            try {
                i = (int) (new JSONObject(str).optDouble("quality") * 100.0d);
            } catch (Exception e2) {
                e2.printStackTrace();
                i = -1;
            }
            final int i2 = (i <= 0 || 100 < i) ? -1 : i;
            IdCardDetectionController.getInstance().startIdcarddetect(context, 6, new IdCardDetectionController.IIdCardDetectionListener() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.17
                @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
                public void onDetectFailed(int i3, String str3) {
                    if (i3 != -1) {
                        if (i3 == -2) {
                            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_CANCEL, "取消", "#callCameraFail");
                            return;
                        }
                        return;
                    }
                    LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
                    LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
                    data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
                    data.des = PhoneUtils.getApplicationName(context) + "没有访问相机的权限";
                    iLightappInvokerCallback.onResult(1, lightAppTakePictureModel.toJson());
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(CheckUtils.stripUrlParams(str2));
                    arrayList2.add("1:" + str3);
                    PayStatisticsUtil.onEventWithValues("#callCameraFail", arrayList2);
                }

                @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
                public void onDetectOK(Bundle bundle) {
                    if (bundle == null) {
                        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                        if (iLightappInvokerCallback2 != null) {
                            iLightappInvokerCallback2.onResult(1, "internal error");
                            return;
                        }
                        return;
                    }
                    String string = bundle.getString("pic1");
                    final LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(0);
                    ImageBase64Utils.ImageBase64Listener imageBase64Listener = new ImageBase64Utils.ImageBase64Listener() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.17.1
                        @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                        public void onBase64Result(String str3) {
                            LightAppTakePictureModel lightAppTakePictureModel2 = lightAppTakePictureModel;
                            lightAppTakePictureModel2.cnt.image = str3;
                            iLightappInvokerCallback.onResult(0, lightAppTakePictureModel2.toJson());
                        }
                    };
                    ImageBase64Utils imageBase64Utils = ImageBase64Utils.getInstance();
                    int i3 = i2;
                    if (i3 > 0) {
                        imageBase64Utils.getImageBase64(string, -1, i3, imageBase64Listener);
                    } else {
                        imageBase64Utils.getImageBase64(string, 640, imageBase64Listener);
                    }
                }
            }, false);
            return;
        }
        LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + parseJsonInt, "#callCameraFail");
    }

    public void callIDPotos(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        a(METHOD_CALL_ID_PHOTOS, str);
        int parseJsonInt = LightappUtils.parseJsonInt(str, "type");
        int i = 1 == parseJsonInt ? 1 : 2 == parseJsonInt ? 3 : 3 == parseJsonInt ? 4 : 4 == parseJsonInt ? 5 : 5 == parseJsonInt ? 6 : -1;
        if (i > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(CheckUtils.stripUrlParams(str2));
            arrayList.add("" + i);
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.LIGHT_APP_EVENTID_CALL_ID_PHOTOS, arrayList);
            a(context, i, iLightappInvokerCallback, str2, LightappUtils.parseJsonInt(str, "showalbum") == 1);
            return;
        }
        LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + i, "#callIDPotosFail");
    }

    public void callQRCodeScanner(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        PayStatisticsUtil.onEventWithValue("#callQRCodeScanner", CheckUtils.stripUrlParams(str2));
        if (LightappUtils.parseJsonInt(str, "needScanResult") == f24983c) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER).action("qrcodescanresult"), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.4
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap) {
                    if (i == 0 && hashMap != null) {
                        String str3 = (String) hashMap.get("value");
                        LightAppCallQRCodeScannerModel lightAppCallQRCodeScannerModel = new LightAppCallQRCodeScannerModel();
                        lightAppCallQRCodeScannerModel.result = 0;
                        if (!TextUtils.isEmpty(str3)) {
                            lightAppCallQRCodeScannerModel.cnt.scanResult = Base64.encodeToString(str3.getBytes(), 2);
                        }
                        iLightappInvokerCallback.onResult(0, lightAppCallQRCodeScannerModel.toJson());
                    } else if (i == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER);
                        hashMap2.put("action", "qrcodescanresult");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                    } else if (i != 1 || hashMap == null) {
                    } else {
                        int intValue = ((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue();
                        String str4 = (String) hashMap.get("errorMsg");
                        if (intValue == 2 && TextUtils.equals(str4, "camera_permission_denied")) {
                            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_NO_PERMISSION, LightappBusinessClient.this.a(context, "访问相机的权限"), "#callQRCodeScannerFail");
                        } else if (intValue == 0) {
                            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_CANCEL, "取消", "#callQRCodeScannerFail");
                        }
                    }
                }
            });
        }
        BaiduWalletServiceController.getInstance().gotoWalletService(context, "32768", "");
    }

    public void changePayMethod(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (iLightappInvokerCallback == null) {
            return;
        }
        if (getActivity() != null) {
            getActivity();
        } else if (context == null || !(context instanceof Activity)) {
            return;
        } else {
            Activity activity = (Activity) context;
        }
        PayStatisticsUtil.onEventWithValue("#changePayMethod", CheckUtils.stripUrlParams(str2));
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterChangePayMethod").data("options", str), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.14
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 0) {
                    if (hashMap == null || hashMap.size() <= 0) {
                        return;
                    }
                    String str3 = (String) hashMap.get("result");
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    try {
                        if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                            iLightappInvokerCallback.onResult(0, str3);
                        } else {
                            iLightappInvokerCallback.onResult(1, str3);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(CheckUtils.stripUrlParams(str2));
                            arrayList.add(str3);
                            PayStatisticsUtil.onEventWithValues("#changePayMethodFail", arrayList);
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                String str4 = (String) hashMap.get("errorMsg");
                ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                String str5 = str2;
                String num = Integer.toString(i);
                if (TextUtils.isEmpty(str4)) {
                    str4 = LightappConstants.ROUTER_INVOKE_FAIL;
                }
                LightappUtils.onError(iLightappInvokerCallback2, str5, num, str4, "#changePayMethodFail");
            }
        });
    }

    public void checkPermission() {
        char c2;
        String str = this.G;
        int hashCode = str.hashCode();
        if (hashCode == -1367751899) {
            if (str.equals(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMERA)) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 263762004) {
            if (hashCode == 1901043637 && str.equals("location")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals("address_book")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        String str2 = c2 != 0 ? c2 != 1 ? c2 != 2 ? "" : "android.permission.READ_CONTACTS" : "android.permission.ACCESS_FINE_LOCATION" : PermissionRequest.RESOURCE_VIDEO_CAPTURE;
        LightAppInfoModel lightAppInfoModel = new LightAppInfoModel();
        if (!TextUtils.isEmpty(str2) && PermissionManager.checkCallingPermission(getActivity(), str2)) {
            lightAppInfoModel.result = 0;
            lightAppInfoModel.state = "permission granted";
        } else {
            lightAppInfoModel.result = -1;
            lightAppInfoModel.state = "permission denied";
        }
        a(MTD_GO_TO_APP_SETTING, 0, lightAppInfoModel.toJson());
    }

    public void detectBankCard(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        a(METHOD_DETECT_BANKCARD, str);
        PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_DETECT_BANKCARD, CheckUtils.stripUrlParams(str2));
        if (LocalRouter.getInstance(context).isProviderExisted("bankdetection")) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.19
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap) {
                    if (i == 0) {
                        if (hashMap == null || TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                            return;
                        }
                        String str3 = (String) hashMap.get("card_num");
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        LightAppDetectBankcardModel lightAppDetectBankcardModel = new LightAppDetectBankcardModel(0);
                        lightAppDetectBankcardModel.cnt.data = str3;
                        iLightappInvokerCallback.onResult(0, lightAppDetectBankcardModel.toJson());
                    } else if (i != 1 || hashMap == null) {
                        if (i == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "bankdetection");
                            hashMap2.put("action", "bankcarddetction");
                            DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                            PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                        }
                    } else if (((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue() == -1) {
                        ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                        String str4 = str2;
                        LightappUtils.onError(iLightappInvokerCallback2, str4, LightappConstants.ERRCODE_NO_PERMISSION, PhoneUtils.getApplicationName(context) + "没有访问相机的权限", "#detectBankCardFail");
                    } else if (((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue() == -2) {
                        LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_CANCEL, "取消", "#detectBankCardFail");
                    }
                }
            });
        }
    }

    public void detectLiveness(final Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        a("detectLiveness", str);
        try {
            HashMap hashMap = (HashMap) JsonUtils.fromJson(str, HashMap.class);
            PayStatisticsUtil.onEventWithValue("#faceRegister", CheckUtils.stripUrlParams(str2));
            if (LocalRouter.getInstance(context).isProviderExisted("livenessdetect")) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("livenessdetect").action("livenessdetect").data(hashMap), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.18
                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i, HashMap hashMap2) {
                        if (i == 0) {
                            if (hashMap2 != null) {
                                Object obj = hashMap2.get("value");
                                if (obj instanceof JSONObject) {
                                    try {
                                        LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(0);
                                        lightAppCommonModel.cnt.data = (HashMap) JsonUtils.fromJson(((JSONObject) obj).toString(), HashMap.class);
                                        iLightappInvokerCallback.onResult(0, lightAppCommonModel.toJson());
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        } else if (i == 5) {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("provider", "livenessdetect");
                            hashMap3.put("action", "livenessdetect");
                            DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                            PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                        } else {
                            LightappUtils.onError(iLightappInvokerCallback, str2, i + "", PhoneUtils.getApplicationName(context) + ((String) hashMap2.get("errorMsg")), "#faceRegisterFail");
                        }
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void doBindCard(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2, final String str3) {
        if (TextUtils.isEmpty(str3)) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_BINDCARD, CheckUtils.stripUrlParams(str2));
        }
        String str4 = "";
        this.f24985d = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLDecoder.decode(str, "gbk");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    str4 = (String) jSONObject.get("orderInfo");
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    this.f24985d = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterDoInnerBind").data("showDialog", Boolean.valueOf(this.f24985d)).data("orderInfo", str4), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.21
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 0) {
                    if (hashMap == null || hashMap.size() <= 0) {
                        return;
                    }
                    int intValue = ((Integer) hashMap.get("statusCode")).intValue();
                    String str5 = (String) hashMap.get("params");
                    if (intValue == 0) {
                        iLightappInvokerCallback.onResult(0, str5);
                        return;
                    }
                    ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                    String str6 = str2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("#");
                    sb.append(TextUtils.isEmpty(str3) ? LightappBusinessClient.METHOD_DO_BIND_CARD : str3);
                    sb.append("Fail");
                    LightappUtils.onError(iLightappInvokerCallback2, str6, LightappConstants.ERRCODE_CANCEL, str5, sb.toString());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(CheckUtils.stripUrlParams(str2));
                    arrayList.add(str5);
                    PayStatisticsUtil.onEventWithValues("#doBindCardFail", arrayList);
                    return;
                }
                String str7 = (String) hashMap.get("errorMsg");
                ILightappInvokerCallback iLightappInvokerCallback3 = iLightappInvokerCallback;
                String str8 = str2;
                String num = Integer.toString(i);
                if (!TextUtils.isEmpty(str7)) {
                    str7 = LightappConstants.ROUTER_INVOKE_FAIL;
                }
                LightappUtils.onError(iLightappInvokerCallback3, str8, num, str7, "#doBindCardFail");
            }
        });
    }

    public void doRnAuth(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        PayStatisticsUtil.onEventWithValue("#doRnAuth", CheckUtils.stripUrlParams(str2));
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    str3 = (String) new JSONObject(str).get("orderInfo");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterDoRnAuth").data(getUrlParam(str3)), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.23
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 0) {
                    if (hashMap == null || hashMap.size() <= 0) {
                        return;
                    }
                    int intValue = ((Integer) hashMap.get("statusCode")).intValue();
                    String str4 = (String) hashMap.get("authDesc");
                    if (intValue == 0) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", intValue);
                            jSONObject.put("cnt", str4);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        iLightappInvokerCallback.onResult(0, jSONObject.toString());
                        return;
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(intValue), str4, "#doRnAuthFail");
                    return;
                }
                String str5 = (String) hashMap.get("errorMsg");
                ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                String str6 = str2;
                String num = Integer.toString(i);
                if (!TextUtils.isEmpty(str5)) {
                    str5 = LightappConstants.ROUTER_INVOKE_FAIL;
                }
                LightappUtils.onError(iLightappInvokerCallback2, str6, num, str5, "#doRnAuthFail");
            }
        });
    }

    public void dopay(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_BD_DOPAY, CheckUtils.stripUrlParams(str2));
        this.f24985d = false;
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    str3 = (String) jSONObject.get("orderInfo");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    this.f24985d = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterDoPayWithParams").data("orderInfo", str3).data("showDialog", Boolean.valueOf(this.f24985d)), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.20
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 0) {
                    if (hashMap == null || hashMap.size() <= 0) {
                        return;
                    }
                    int intValue = ((Integer) hashMap.get("statusCode")).intValue();
                    String str4 = (String) hashMap.get("payDesc");
                    if (intValue != 0 && intValue != 1) {
                        iLightappInvokerCallback.onResult(1, str4);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(CheckUtils.stripUrlParams(str2));
                        arrayList.add(str4);
                        PayStatisticsUtil.onEventWithValues("#dopayFail", arrayList);
                        return;
                    }
                    iLightappInvokerCallback.onResult(0, str4);
                    return;
                }
                String str5 = (String) hashMap.get("errorMsg");
                ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                String str6 = str2;
                String num = Integer.toString(i);
                if (!TextUtils.isEmpty(str5)) {
                    str5 = LightappConstants.ROUTER_INVOKE_FAIL;
                }
                LightappUtils.onError(iLightappInvokerCallback2, str6, num, str5, "#dopayFail");
            }
        });
    }

    public void finalize() throws Throwable {
        super.finalize();
        HandlerThread handlerThread = this.D;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        HashMap<String, b> hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public Activity getActivity() {
        com.baidu.wallet.lightapp.multipage.a aVar = this.B;
        if (aVar != null) {
            return aVar.getActivity();
        }
        return null;
    }

    public ILightappInvokerCallback getH5BackCb() {
        return this.C;
    }

    public void getLoadTimeLine(ILightappInvokerCallback iLightappInvokerCallback) {
        if (iLightappInvokerCallback != null) {
            String loadTimeLine = this.B.getLoadTimeLine();
            String str = this.f24984a;
            LogUtil.d(str, "getLoadTimeLine result = " + loadTimeLine);
            iLightappInvokerCallback.onResult(0, loadTimeLine);
        }
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        HashSet hashSet = new HashSet();
        hashSet.add(METHOD_CALL_CAMERA);
        if (c(METHOD_CALL_QRCODE_SCANNER)) {
            hashSet.add(METHOD_CALL_QRCODE_SCANNER);
        }
        hashSet.add(METHOD_CALL_ID_PHOTOS);
        if (c(METHOD_DETECT_BANKCARD)) {
            hashSet.add(METHOD_DETECT_BANKCARD);
        }
        if (c(METHOD_DETECT_LIVENESS)) {
            hashSet.add(METHOD_DETECT_LIVENESS);
        }
        hashSet.add(METHOD_INIT_PAY);
        hashSet.add(METHOD_DO_PAY);
        hashSet.add(METHOD_DO_BIND_CARD);
        hashSet.add(METHOD_DO_RN_AUTH);
        hashSet.add(METHOD_ACCESS_WALLET_SERVICE);
        hashSet.add(METHOD_BD_LOGIN);
        hashSet.add(METHOD_GET_USER_AGENT);
        hashSet.add(MTD_CALLPHONEINFO);
        hashSet.add("setTitle");
        hashSet.add(MTD_SETMENU);
        hashSet.add(MTD_H5GOBCK);
        hashSet.add(MTD_STATEVENT);
        hashSet.add("callNativeVoice");
        hashSet.add(MTD_OPEN_IN_BROWSER);
        hashSet.add(MTD_DIGEST);
        hashSet.add(MTD_ENCRYPT);
        hashSet.add(MTD_DECRYPT);
        hashSet.add(MTD_BINDCARD_INDEPENDENT);
        hashSet.add(MTD_BINDCARD_INITIATIVE);
        hashSet.add("selectPhonefromAdressBook");
        hashSet.add(MTD_CUSTOMER_SERVICE);
        hashSet.add("getPayMethod");
        hashSet.add("changePayMethod");
        hashSet.add("preOrderPay");
        hashSet.add(MTD_START_AUDIO_RECORD);
        hashSet.add(MTD_END_AUDIO_RECORD);
        hashSet.add(MTD_LIST_MY_BANK_CARD);
        hashSet.add(MTD_GET_SUPPORT_LIST);
        hashSet.add(MTD_SET_FULLSCREEN);
        hashSet.add(METHOD_SET_RN_AUTH_RUSULT);
        hashSet.add(METHOD_POST_EVENT);
        hashSet.add(METHOD_GET_SUPPORT_LIVENESS);
        hashSet.add(MTD_CALL_NATIVE_PHOTO);
        hashSet.add(MTD_GET_LOAD_TIME_LINE);
        hashSet.add(MTD_GO_TO_APP_SETTING);
        hashSet.add(MTD_SEND_TO_SMS);
        hashSet.add(MTD_GET_PERMISSION_STATE);
        hashSet.add(MTD_GET_OFFLINE_INFO);
        hashSet.add(MTD_UPLOAD_MSG);
        return hashSet;
    }

    public void getOfflineCacheInfo(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        JSONObject offlineCacheInfo = LangbridgeCacheManager.getInstance().getOfflineCacheInfo(str2);
        if (offlineCacheInfo == null) {
            offlineCacheInfo = new JSONObject();
        }
        iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, offlineCacheInfo));
    }

    public void getPayMethod(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (iLightappInvokerCallback == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValue("#getPayMethod", CheckUtils.stripUrlParams(str2));
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterGetPayMethod").data("options", str), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.13
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i != 0 || hashMap == null || hashMap.size() <= 0) {
                    return;
                }
                String str3 = (String) hashMap.get("result");
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                try {
                    if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                        iLightappInvokerCallback.onResult(0, str3);
                        return;
                    }
                    iLightappInvokerCallback.onResult(1, str3);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(CheckUtils.stripUrlParams(str2));
                    arrayList.add(str3);
                    PayStatisticsUtil.onEventWithValues("#getPayMethodFail", arrayList);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    @SuppressLint({"DefaultLocale"})
    public HashMap<String, String> getSinalParam(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split != null && !TextUtils.isEmpty(split[0])) {
                    hashMap.put(split[0], split.length > 1 ? URLDecoder.decode(split[1]) : "");
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public void getSupportedMethodList(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        if (iLightappInvokerCallback == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValue("#getSupportedMethodList", CheckUtils.stripUrlParams(str2));
        JSONObject jSONObject = new JSONObject();
        Set<String> supportMethodList = LightappJsNativeClient.getSupportMethodList(context);
        supportMethodList.addAll(getMethodList());
        supportMethodList.add(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE);
        try {
            jSONObject.put("data", new JSONArray(JsonUtils.toJson(supportMethodList)));
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
        } catch (JSONException e2) {
            e2.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INNER_ERROR, "失败", "#getSupportedMethodListFail");
        }
    }

    public HashMap<String, String> getUrlParam(String str) {
        String str2;
        if (str.contains("input_charset=1")) {
            try {
                str2 = EncodeUtils.gbk2utf8(URLDecoder.decode(str, "gbk"));
            } catch (UnsupportedEncodingException unused) {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        }
        return getSinalParam(str);
    }

    public void getUserAgent(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_GET_UA, CheckUtils.stripUrlParams(str2));
        String ua = BussinessUtils.getUA(context);
        if (LightappUtils.parseJsonInt(str, "base64") == f24982b) {
            ua = Base64.encodeToString(ua.getBytes(), 2);
        }
        LightAppUserAgentModel lightAppUserAgentModel = new LightAppUserAgentModel(0);
        lightAppUserAgentModel.cnt.data = ua;
        iLightappInvokerCallback.onResult(0, lightAppUserAgentModel.toJson());
    }

    public void initpay(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        PayStatisticsUtil.onEventWithValue("#initpay", CheckUtils.stripUrlParams(str2));
        if (!TextUtils.isEmpty(str)) {
            try {
                str3 = (String) new JSONObject(str).get(LightappConstants.INIT_PAY_PARAM_INIT_PARAM);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            new HashMap().put("sp", str3);
        }
        str3 = "";
        new HashMap().put("sp", str3);
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        if (TextUtils.isEmpty(str)) {
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(1, "invalid options");
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = (String) jSONObject.get("method_name");
            this.z.put(str2, iLightappInvokerCallback);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str3 = (String) jSONObject.get(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            if (!JavascriptInterfaceManager.verifyPermission(new URL(str3), str2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(CheckUtils.stripUrlParams(str3));
                arrayList.add(str2);
                LightappUtils.onError(iLightappInvokerCallback, LightappConstants.ERRCODE_HOST_NOT_AUTHORITY, ResUtils.getString(context, "host_not_authority"), LightAppStatEvent.LIGHT_APP_NOT_INTERNAL_URL, arrayList);
            } else if (METHOD_CALL_CAMERA.equals(str2)) {
                callCamera(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_CALL_QRCODE_SCANNER.equals(str2)) {
                if (!LocalRouter.getInstance(context).isProviderExisted(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER)) {
                    GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_not_include_tips"));
                } else {
                    callQRCodeScanner(context, str, iLightappInvokerCallback, str3);
                }
            } else if (METHOD_CALL_ID_PHOTOS.equals(str2)) {
                callIDPotos(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_DETECT_BANKCARD.equals(str2)) {
                detectBankCard(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_INIT_PAY.equals(str2)) {
                initpay(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_DO_PAY.equals(str2)) {
                dopay(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_DO_BIND_CARD.equals(str2)) {
                doBindCard(context, str, iLightappInvokerCallback, str3, null);
            } else if (METHOD_DO_RN_AUTH.equals(str2)) {
                doRnAuth(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_ACCESS_WALLET_SERVICE.equals(str2)) {
                accessWalletService(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_BD_LOGIN.equals(str2)) {
                bdLogin(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_GET_USER_AGENT.equals(str2)) {
                getUserAgent(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_CALLPHONEINFO.equals(str2)) {
                v(context, str, iLightappInvokerCallback, str3);
            } else if ("setTitle".equals(str2)) {
                p(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_SET_FULLSCREEN.equals(str2)) {
                q(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_SETMENU.equals(str2)) {
                t(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_H5GOBCK.equals(str2)) {
                u(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_STATEVENT.equals(str2)) {
                r(context, str, iLightappInvokerCallback, str3);
            } else if ("callNativeVoice".equals(str2)) {
                g(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_OPEN_IN_BROWSER.equals(str2)) {
                s(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_DIGEST.equals(str2)) {
                n(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_ENCRYPT.equals(str2)) {
                a(context, str, iLightappInvokerCallback, str3, true);
            } else if (MTD_DECRYPT.equals(str2)) {
                a(context, str, iLightappInvokerCallback, str3, false);
            } else if (MTD_BINDCARD_INDEPENDENT.equals(str2)) {
                b(context, str, iLightappInvokerCallback, str3, true);
            } else if (MTD_BINDCARD_INITIATIVE.equals(str2)) {
                b(context, str, iLightappInvokerCallback, str3, false);
            } else if ("selectPhonefromAdressBook".equals(str2)) {
                o(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_CUSTOMER_SERVICE.equals(str2)) {
                e(context, str, iLightappInvokerCallback, str3);
            } else if ("getPayMethod".equals(str2)) {
                getPayMethod(context, str, iLightappInvokerCallback, str3);
            } else if ("changePayMethod".equals(str2)) {
                changePayMethod(context, str, iLightappInvokerCallback, str3);
            } else if ("preOrderPay".equals(str2)) {
                preOrderPay(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_START_AUDIO_RECORD.equals(str2)) {
                a(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_END_AUDIO_RECORD.equals(str2)) {
                c(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_LIST_MY_BANK_CARD.equals(str2)) {
                d(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_GET_SUPPORT_LIST.equals(str2)) {
                getSupportedMethodList(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_SET_RN_AUTH_RUSULT.equals(str2)) {
                setRnAuthResultInMainThread(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_POST_EVENT.equals(str2)) {
                postEvent(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_DETECT_LIVENESS.equals(str2)) {
                detectLiveness(context, str, iLightappInvokerCallback, str3);
            } else if (METHOD_GET_SUPPORT_LIVENESS.equals(str2)) {
                f(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_CALL_NATIVE_PHOTO.equals(str2)) {
                w(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_GET_LOAD_TIME_LINE.equals(str2)) {
                getLoadTimeLine(iLightappInvokerCallback);
            } else if (MTD_GET_OFFLINE_INFO.equals(str2)) {
                getOfflineCacheInfo(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_UPLOAD_MSG.equals(str2)) {
                z(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_GO_TO_APP_SETTING.equals(str2)) {
                b(context, jSONObject);
            } else if (MTD_SEND_TO_SMS.equals(str2)) {
                x(context, str, iLightappInvokerCallback, str3);
            } else if (MTD_GET_PERMISSION_STATE.equals(str2)) {
                y(context, str, iLightappInvokerCallback, str3);
            } else {
                DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_METHOD_NOT_SUPPORT, Arrays.asList(str));
                PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_INVOKE_METHOD_NOT_SUPPORT, str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void login(String str, String str2, String str3) {
        LogUtil.d("bdLogin. options = " + str + ", success = " + str2 + ", fail = " + str3);
    }

    public void onContactsSelected(String str, int i, String[] strArr, String str2, final String str3) {
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
            if (TextUtils.equals(str2, "取消")) {
                contactSelectModel.cnt.errCode = LightappConstants.ERRCODE_CANCEL;
            } else {
                contactSelectModel.cnt.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            }
            contactSelectModel.cnt.des = str2;
            a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
        } else if (strArr != null) {
            String str4 = strArr.length > 0 ? strArr[0] : "";
            String str5 = strArr.length > 1 ? strArr[1] : "";
            contactSelectModel.result = 0;
            ContactSelectModel.Data data = contactSelectModel.cnt;
            ContactSelectModel.SelectedContact selectedContact = data.selected;
            selectedContact.name = str4;
            selectedContact.phone = str5;
            if (q == v) {
                PhoneContactsMananger.a(getActivity()).a(new PhoneContactsMananger.d() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.11
                    @Override // com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger.d
                    public void a(List<ContactSelectModel.AllContact> list, int i2) {
                        if (LightappBusinessClient.t != null) {
                            contactSelectModel.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), LightappBusinessClient.t));
                            if (TextUtils.isEmpty(str3)) {
                                contactSelectModel.cnt.allCount = "0";
                            } else {
                                contactSelectModel.cnt.allCount = str3;
                            }
                        } else {
                            contactSelectModel.cnt.all = list;
                            if (TextUtils.isEmpty(str3)) {
                                contactSelectModel.cnt.allCount = "0";
                            } else if (list != null) {
                                ContactSelectModel.Data data2 = contactSelectModel.cnt;
                                data2.allCount = list.size() + "";
                            } else {
                                contactSelectModel.cnt.allCount = str3;
                            }
                        }
                        if (LightappBusinessClient.s != LightappBusinessClient.A) {
                            LightappBusinessClient.this.a("selectPhonefromAdressBook", 0, contactSelectModel.toJson());
                            return;
                        }
                        LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                        ContactSelectModel contactSelectModel2 = contactSelectModel;
                        lightAppContactSelectModelBase64.result = contactSelectModel2.result;
                        ContactSelectModel.Data data3 = contactSelectModel2.cnt;
                        if (data3 != null) {
                            lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data3).getBytes());
                        }
                        LightappBusinessClient.this.a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
                    }
                });
                if (r > 0) {
                    PhoneContactsMananger.a(getActivity()).a(r, false);
                } else {
                    PhoneContactsMananger.a(getActivity()).a(1000, false);
                }
            } else if (s == A) {
                LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                lightAppContactSelectModelBase64.result = contactSelectModel.result;
                if (contactSelectModel.cnt != null) {
                    if (TextUtils.isEmpty(str3)) {
                        contactSelectModel.cnt.allCount = "0";
                    } else {
                        contactSelectModel.cnt.allCount = str3;
                    }
                    lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(contactSelectModel.cnt).getBytes());
                }
                a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
            } else {
                if (data != null) {
                    if (TextUtils.isEmpty(str3)) {
                        contactSelectModel.cnt.allCount = "0";
                    } else {
                        contactSelectModel.cnt.allCount = str3;
                    }
                }
                a("selectPhonefromAdressBook", 0, contactSelectModel.toJson());
            }
        }
    }

    public void onRequestPermissionsResult(String str, int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        if (244 == i) {
            b bVar = this.F.get(MTD_START_AUDIO_RECORD);
            if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                while (i2 < strArr.length) {
                    if (PermissionRequest.RESOURCE_AUDIO_CAPTURE.equals(strArr[i2])) {
                        if (bVar != null) {
                            b(bVar.f25088a, bVar.f25089b, bVar.f25090c, bVar.f25091d);
                            return;
                        }
                        return;
                    }
                    i2++;
                }
                return;
            }
            LightappUtils.onError(bVar != null ? bVar.f25090c : null, str, LightappConstants.ERRCODE_NO_PERMISSION, "无录音权限", "startRecordingFail");
        } else if (243 == i) {
            if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                while (i2 < strArr.length) {
                    if ("android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i2])) {
                        if (i2 < iArr.length) {
                            int i3 = iArr[i2];
                            if (i3 != 0) {
                                if (i3 == -1) {
                                    a(str);
                                    return;
                                }
                                return;
                            }
                            com.baidu.wallet.lightapp.multipage.a aVar = this.B;
                            if (aVar != null) {
                                aVar.selectPhoneFromAddressBook();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    i2++;
                }
                return;
            }
            a(str);
        } else if (245 != i && 246 != i) {
            if (i == 4) {
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    while (i2 < strArr.length) {
                        if ("android.permission.READ_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i2]) && i2 < iArr.length && iArr[i2] == -1) {
                            b(MTD_CALL_NATIVE_PHOTO, "没有存储权限");
                            return;
                        }
                        i2++;
                    }
                    this.B.loadAlubm(this.p);
                    return;
                }
                b(MTD_CALL_NATIVE_PHOTO, "没有存储权限");
            }
        } else if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
            while (i2 < strArr.length) {
                if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i2])) {
                    if (i2 < iArr.length && iArr[i2] == -1) {
                        b("没有相机权限");
                        return;
                    }
                } else if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i2]) && i2 < iArr.length && iArr[i2] == -1) {
                    b("没有存储权限");
                    return;
                }
                i2++;
            }
            if (245 == i) {
                k(getActivity(), this.n, this.o, str);
            } else if (246 == i) {
                m(getActivity(), this.n, this.o, str);
            }
        } else {
            b("没有相机和存储权限");
        }
    }

    public void postEvent(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        PayStatisticsUtil.onEventWithValue("#postEvent", CheckUtils.stripUrlParams(str2));
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("event_key");
            String string2 = jSONObject.getString("event_value");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (!TextUtils.isEmpty(string2)) {
                byte[] decode = Base64.decode(string2, 2);
                string2 = decode == null ? "" : new String(decode);
            }
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            EventBus.getInstance().post(new EventBus.Event(string, string2));
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, "");
            }
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#postEventFail");
        }
    }

    public void preOrderPay(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (iLightappInvokerCallback == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValue("#preOrderPay", CheckUtils.stripUrlParams(str2));
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterPreOrderPay").data("options", str), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.15
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 0) {
                    if (hashMap == null || hashMap.size() <= 0) {
                        return;
                    }
                    String str3 = (String) hashMap.get("result");
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    try {
                        if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                            iLightappInvokerCallback.onResult(0, str3);
                        } else {
                            iLightappInvokerCallback.onResult(1, str3);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(CheckUtils.stripUrlParams(str2));
                            arrayList.add(str3);
                            PayStatisticsUtil.onEventWithValues("#preOrderPayFail", arrayList);
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                String str4 = (String) hashMap.get("errorMsg");
                ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                String str5 = str2;
                String num = Integer.toString(i);
                if (TextUtils.isEmpty(str4)) {
                    str4 = LightappConstants.ROUTER_INVOKE_FAIL;
                }
                LightappUtils.onError(iLightappInvokerCallback2, str5, num, str4, "#preOrderPayFail");
            }
        });
    }

    public void setAlubmPhotoData(int i, JSONObject jSONObject) {
        String str = this.f24984a;
        LogUtil.d(str, "resultCode = " + i + " ; jsonObject = " + jSONObject.toString());
        a(MTD_CALL_NATIVE_PHOTO, i, LightappUtils.assembleResult(i, jSONObject));
    }

    public void setH5BackCb(ILightappInvokerCallback iLightappInvokerCallback) {
        this.C = iLightappInvokerCallback;
    }

    public void setRnAuthResult(Context context, String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        String str3 = "";
        LogUtil.d("lightapp", "setRnAuthResult url = " + str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                int intValue = ((Integer) jSONObject.get("rnauth_result")).intValue();
                try {
                    String str4 = (String) jSONObject.get("rnauth_des");
                    try {
                        iLightappInvokerCallback.onResult(0, "");
                        LogUtil.d(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE, "setRnAuthResult OK");
                        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data("statusCode", Integer.valueOf(intValue)).data("desc", str4), new RouterCallback() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.3
                            @Override // com.baidu.wallet.router.RouterCallback
                            public void onResult(int i2, HashMap hashMap) {
                                if (i2 != 0) {
                                    LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i2), "invoke_method_fail_from_router", "#setRnAuthResultFail");
                                    return;
                                }
                                String str5 = (String) hashMap.get("errorMsg");
                                ILightappInvokerCallback iLightappInvokerCallback2 = iLightappInvokerCallback;
                                String str6 = str2;
                                String num = Integer.toString(i2);
                                if (!TextUtils.isEmpty(str5)) {
                                    str5 = LightappConstants.ROUTER_INVOKE_FAIL;
                                }
                                LightappUtils.onError(iLightappInvokerCallback2, str6, num, str5, "#setRnAuthResultFail");
                            }
                        });
                    } catch (JSONException e2) {
                        e = e2;
                        str3 = str4;
                        i = intValue;
                        e.printStackTrace();
                        LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i), str3, "#setRnAuthResultFail");
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
            } catch (JSONException e4) {
                e = e4;
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i), str3, "#setRnAuthResultFail");
        }
    }

    public void setRnAuthResultInMainThread(final Context context, final String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        Runnable runnable = new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.2
            @Override // java.lang.Runnable
            public void run() {
                LightappBusinessClient.this.setRnAuthResult(context, str, iLightappInvokerCallback, str2);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private void d(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        JSONObject jSONObject;
        PayStatisticsUtil.onEventWithValue("#listMyBankCard", CheckUtils.stripUrlParams(str2));
        try {
            String optString = ((JSONObject) new JSONTokener(str).nextValue()).optString("params", null);
            if (optString != null) {
                jSONObject = (JSONObject) new JSONTokener(optString).nextValue();
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("source_flag", 3);
            jSONObject.put("request_type", 11);
            BaiduWalletServiceController.getInstance().gotoWalletService((Context) getActivity(), 4L, jSONObject.toString(), true);
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getMessage(), "#listMyBankCardFail");
        }
    }

    private void e(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            String optString = new JSONObject(str).optString("data", null);
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject = (JSONObject) new JSONTokener(optString).nextValue();
                if (jSONObject.has("en")) {
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_APP_CUSTOMER_SERVICE_EVENT_KEY, Arrays.asList(jSONObject.optString("en", ""), jSONObject.optString("ev", ""), jSONObject.optString("eg", ""), jSONObject.optString("at", "")));
                    if (CustomerService.getInstance().isEnabled()) {
                        CustomerService.getInstance().enqueEvent(jSONObject.optString("en", null), jSONObject.optString("ev", null), jSONObject.optString("eg", null), jSONObject.optString("at", null));
                        if (iLightappInvokerCallback != null) {
                            iLightappInvokerCallback.onResult(0, "{\"result\":0}");
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new InvalidParameterException("invalid parameter [data->en] (null)");
            }
            throw new InvalidParameterException("invalid parameter [data] (null)");
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#customerServiceFail");
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, IGET, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION] complete} */
    private void f(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (!this.w) {
            try {
                this.f24986e = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                Class<?> cls = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                this.f24988g = cls;
                this.f24987f = this.f24986e.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, Context.class, String.class, Boolean.TYPE, cls);
                jSONArray.put("0");
            } finally {
                try {
                } finally {
                }
            }
        } else if (this.f24986e != null && this.f24988g != null && this.f24987f != null) {
            jSONArray.put("0");
        }
        if (LocalRouter.getInstance(context).isProviderExisted("livenessidentifyauth")) {
            jSONArray.put("1");
        }
        if (Build.VERSION.SDK_INT >= 18) {
            if (!this.x) {
                try {
                    this.f24989h = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessManager");
                    Class<?> cls2 = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessCallback");
                    this.j = cls2;
                    this.i = this.f24989h.getDeclaredMethod("startDetact", Context.class, String.class, cls2);
                    jSONArray.put("2");
                } finally {
                    try {
                    } finally {
                    }
                }
            } else if (this.f24989h != null && this.j != null && this.i != null) {
                jSONArray.put("2");
            }
        }
        if (d()) {
            jSONArray.put("3");
        }
        try {
            jSONObject2.put("data", jSONArray);
            jSONObject.put("result", 0);
            jSONObject.put("cnt", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        iLightappInvokerCallback.onResult(0, jSONObject.toString());
    }

    private void g(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        this.n = str;
        this.o = iLightappInvokerCallback;
        PayStatisticsUtil.onEventWithValue("#callNativeVoice", CheckUtils.stripUrlParams(str2));
        try {
            String optString = new JSONObject(str).optString("liveness_type", "0");
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 48:
                    if (optString.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 49:
                    if (optString.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 50:
                    if (optString.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 51:
                    if (optString.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                i(context, str, iLightappInvokerCallback, str2);
            } else if (c2 == 1) {
                h(context, str, iLightappInvokerCallback, str2);
            } else if (c2 == 2) {
                j(context, str, iLightappInvokerCallback, str2);
            } else if (c2 != 3) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法", "#callNativeVoice");
            } else {
                l(context, str, iLightappInvokerCallback, str2);
            }
        } catch (JSONException unused) {
        }
    }

    private void c(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        a aVar = new a();
        aVar.f25084e = iLightappInvokerCallback;
        aVar.f25086g = str2;
        this.E.obtainMessage(2, aVar).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        try {
            AudioRecorder.getInstance().end();
            aVar.f25084e.onResult(0, "{\"result\":0}");
        } catch (Exception e2) {
            LightappUtils.onError(aVar.f25084e, aVar.f25086g, LightappConstants.ERRCODE_INNER_ERROR, e2.getLocalizedMessage(), "endRecordingFail");
        }
    }

    private boolean c(String str) {
        return a(str, -1L);
    }

    private void a(String str, String str2) {
        LogUtil.logd("method:" + str + "options=" + str2);
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        try {
            if (PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("callback", null);
                if (LightappJsClient.isJsFunNameValid(optString)) {
                    a aVar = new a();
                    if (!SdpPrefer.AUDIO_STEREO.equals(jSONObject.optString("channelType", "mono"))) {
                        aVar.f25081b = 16;
                    } else {
                        aVar.f25081b = 12;
                    }
                    int optInt = jSONObject.optInt("samplingAccuracy", 16);
                    aVar.f25082c = optInt;
                    if (8 != optInt) {
                        aVar.f25082c = 2;
                    } else {
                        aVar.f25082c = 3;
                    }
                    aVar.f25080a = jSONObject.optInt("samplingRate", 8000);
                    aVar.f25083d = jSONObject.optInt("maxChunkSize", 2048);
                    aVar.f25085f = optString;
                    aVar.f25084e = iLightappInvokerCallback;
                    aVar.f25086g = str2;
                    this.E.obtainMessage(1, aVar).sendToTarget();
                    return;
                }
                throw new InvalidParameterException("invalid parameter [callback]:" + optString);
            }
            throw new AccessControlException(PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        } catch (Exception e2) {
            LightappUtils.onError(iLightappInvokerCallback, str2, e2 instanceof AccessControlException ? LightappConstants.ERRCODE_NO_PERMISSION : LightappConstants.ERRCODE_INVALID_PARAMETER, e2.toString(), "startRecordingFail");
        }
    }

    private void a(Context context, int i, ILightappInvokerCallback iLightappInvokerCallback, String str, boolean z) {
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterIdCardDetect").data("type", Integer.valueOf(i)).data("showAlbum", Boolean.valueOf(z)), new AnonymousClass12(iLightappInvokerCallback, str, context));
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, MOVE_EXCEPTION] complete} */
    private boolean d() {
        if (!this.y) {
            try {
                this.k = Class.forName("com.sensetime.liveness.motion.api.SenseLiveness");
                Class<?> cls = Class.forName("com.sensetime.liveness.motion.api.SenseLivenessCallback");
                this.m = cls;
                this.l = this.k.getDeclaredMethod("startDetect", Context.class, String.class, cls);
            } finally {
                try {
                } finally {
                }
            }
        }
        return (this.k == null || this.m == null || this.l == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        try {
            if (getActivity() != null) {
                final AudioRecorder audioRecorder = AudioRecorder.getInstance();
                if (audioRecorder.init(aVar.f25080a, aVar.f25081b, aVar.f25082c, aVar.f25083d)) {
                    aVar.f25087h = UUID.randomUUID().toString();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("result", 0);
                    jSONObject.put("recordId", aVar.f25087h);
                    aVar.f25084e.onResult(0, jSONObject.toString());
                    final JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("recordId", aVar.f25087h);
                    jSONObject2.put("hasNext", 1);
                    audioRecorder.addObserver(new Observer() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5

                        /* renamed from: a  reason: collision with root package name */
                        public AudioVolume f25057a = new AudioVolume(4000);

                        @Override // java.util.Observer
                        public void update(Observable observable, Object obj) {
                            if (audioRecorder != observable || LightappBusinessClient.this.getActivity() == null) {
                                return;
                            }
                            if (obj instanceof ByteBuffer) {
                                ByteBuffer byteBuffer = (ByteBuffer) obj;
                                this.f25057a.calAccumulatedVolume(byteBuffer, 2 == aVar.f25082c);
                                try {
                                    jSONObject2.put("volume", this.f25057a.getVolume());
                                    LogUtil.d("volume", "update: " + this.f25057a);
                                    jSONObject2.put("data", Base64.encodeToString(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining(), 2));
                                    LightappBusinessClient.this.getActivity().runOnUiThread(new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                LightappBusinessClient.this.B.executeJsFunction(aVar.f25085f, jSONObject2.toString());
                                            } catch (Exception e2) {
                                                LogUtil.e("audioData", "update error: ", e2);
                                            }
                                        }
                                    });
                                } catch (Exception e2) {
                                    LogUtil.e("audioData", "update: ", e2);
                                }
                            } else if (obj instanceof AudioRecorder.State) {
                                if (AudioRecorder.State.STOP == ((AudioRecorder.State) obj)) {
                                    try {
                                        jSONObject2.put("hasNext", 0);
                                        jSONObject2.remove("data");
                                        jSONObject2.remove("volume");
                                        LightappBusinessClient.this.getActivity().runOnUiThread(new Runnable() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    LightappBusinessClient.this.B.executeJsFunction(aVar.f25085f, jSONObject2.toString());
                                                } catch (Exception e3) {
                                                    LogUtil.e("audioData", "update error: ", e3);
                                                }
                                            }
                                        });
                                    } catch (Exception e3) {
                                        LogUtil.e("audioData", "update: ", e3);
                                    }
                                }
                            }
                        }
                    });
                    new Thread(audioRecorder).start();
                    LogUtil.i(MTD_START_AUDIO_RECORD, "ar-->" + audioRecorder);
                    return;
                }
                throw new Exception("can not acquire audio recorder");
            }
            throw new IllegalStateException("activity null");
        } catch (Exception e2) {
            LightappUtils.onError(aVar.f25084e, aVar.f25086g, LightappConstants.ERRCODE_INNER_ERROR, e2.getLocalizedMessage(), "startRecordingFail");
        }
    }

    private void a(final Context context, final String str, final ILightappInvokerCallback iLightappInvokerCallback, final String str2) {
        if (!PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
            BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, getActivity(), new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack() { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.6
                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    if (LightappBusinessClient.this.F == null) {
                        LightappBusinessClient.this.F = new HashMap();
                    }
                    LightappBusinessClient.this.F.put(LightappBusinessClient.MTD_START_AUDIO_RECORD, new b(context, str, iLightappInvokerCallback, str2));
                    if (bool.booleanValue()) {
                        if (PermissionManager.checkCallingOrSelfPermission(LightappBusinessClient.this.getActivity(), new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 244)) {
                            return;
                        }
                        LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_NO_PERMISSION, "无录音权限", "startRecordingFail");
                        return;
                    }
                    LightappBusinessClient.this.onRequestPermissionsResult("", 244, new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, new int[]{-1});
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isShow(String str3, Boolean bool) {
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void requestResult(String str3, Boolean bool) {
                }
            });
        } else {
            b(context, str, iLightappInvokerCallback, str2);
        }
    }

    private void b(String str) {
        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
        data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
        data.des = str;
        a("callNativeVoice", 1, lightAppErrorModel.toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        ContactSelectModel contactSelectModel = new ContactSelectModel(1);
        ContactSelectModel.Data data = contactSelectModel.cnt;
        data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
        data.des = PhoneUtils.getApplicationName(getActivity()) + "没有访问通信录的权限";
        a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str));
        } catch (Exception unused) {
        }
        arrayList.add(contactSelectModel.cnt.des);
        PayStatisticsUtil.onEventWithValues(LightAppStatEvent.LIGHT_APP_EVENTID_SELECT_ADDRESSBOOK_FAIL, arrayList);
    }

    private void b(String str, String str2) {
        LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
        LightAppErrorModel.Data data = lightAppErrorModel.cnt;
        data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
        data.des = str2;
        a(str, 1, lightAppErrorModel.toJson());
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2, boolean z) {
        String str3 = z ? MTD_BINDCARD_INDEPENDENT : MTD_BINDCARD_INITIATIVE;
        PayStatisticsUtil.onEventWithValue("#" + str3, CheckUtils.stripUrlParams(str2));
        doBindCard(context, str, iLightappInvokerCallback, str2, str3);
    }

    private void b(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return;
        }
        try {
            String string = jSONObject.getString("permission_type");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.G = string;
            Intent intent = new Intent();
            this.B.setIsCheckPermission(true);
            try {
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                context.startActivity(intent);
            } catch (Exception unused) {
                context.startActivity(new Intent("android.settings.SETTINGS"));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback;
        try {
            if (this.z == null || (iLightappInvokerCallback = this.z.get(str)) == null) {
                return;
            }
            iLightappInvokerCallback.onResult(i, str2);
            this.z.remove(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2, boolean z) {
        byte[] rsaDecrypt;
        String str3 = z ? MTD_ENCRYPT : MTD_DECRYPT;
        if (iLightappInvokerCallback == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValue("#" + str3, CheckUtils.stripUrlParams(str2));
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("key", null);
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("data", null);
                if (optString2 != null) {
                    String optString3 = jSONObject.optString("algorithm", null);
                    if (optString3 != null) {
                        if (Pattern.compile("DES|AES|RSA").matcher(optString3).matches()) {
                            try {
                                byte[] decode = Base64.decode(optString2, 2);
                                if (decode == null || decode.length == 0) {
                                    throw new IllegalArgumentException("传入的base64数据不正确");
                                }
                                if (z) {
                                    if ("DES".equals(optString3)) {
                                        rsaDecrypt = Crypto.desEncrypt(decode, optString);
                                    } else if ("AES".equals(optString3)) {
                                        rsaDecrypt = Crypto.aesEncrypt(decode, optString);
                                    } else if ("RSA".equals(optString3)) {
                                        rsaDecrypt = Crypto.rsaEncrypt(decode, optString);
                                    } else {
                                        throw new NoSuchAlgorithmException(optString3);
                                    }
                                } else if ("DES".equals(optString3)) {
                                    rsaDecrypt = Crypto.desDecrypt(decode, optString);
                                } else if ("AES".equals(optString3)) {
                                    rsaDecrypt = Crypto.aesDecrypt(decode, optString);
                                } else if ("RSA".equals(optString3)) {
                                    rsaDecrypt = Crypto.rsaDecrypt(decode, optString);
                                } else {
                                    throw new NoSuchAlgorithmException(optString3);
                                }
                                if (rsaDecrypt == null) {
                                    throw new Exception(z ? "encrypt error!" : "decrypt error!");
                                }
                                hashMap.put("data", Base64.encodeToString(rsaDecrypt, 2));
                                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult((Map<String, Object>) hashMap, true));
                                return;
                            } catch (Exception e2) {
                                throw e2;
                            }
                        }
                        throw new NoSuchAlgorithmException("Supported algorithms: DES, AES, RSA." + optString3 + " is not supported yet");
                    }
                    throw new InvalidParameterException("no algorithm key [algorithm]");
                }
                throw new InvalidParameterException("no data key [data]");
            }
            throw new InvalidParameterException("no key [key]");
        } catch (Exception e3) {
            String localizedMessage = e3.getLocalizedMessage();
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, localizedMessage, "#" + str3 + "Fail");
        }
    }

    private String a(Context context, JSONObject jSONObject) throws Exception {
        if (context == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject.has("screenWidth")) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            jSONObject2.put("screenWidth", displayMetrics.widthPixels + "");
        }
        if (jSONObject.has("screenHeight")) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            jSONObject2.put("screenHeight", displayMetrics2.heightPixels + "");
        }
        if (jSONObject.has("walletUserAgent")) {
            jSONObject2.put("walletUserAgent", BussinessUtils.getUA(context) + "");
        }
        if (jSONObject.has("cuid")) {
            jSONObject2.put("cuid", PhoneUtils.getCUID(context) + "");
        }
        if (jSONObject.has("BAIDUCUID")) {
            jSONObject2.put("BAIDUCUID", DeviceId.getCUID(context));
        }
        if (jSONObject.has("location")) {
            String gPSLocation = PhoneUtils.getGPSLocation(context);
            if (TextUtils.isEmpty(gPSLocation)) {
                jSONObject2.put("location", "");
            } else {
                String[] split = gPSLocation.split(":");
                if (split != null && 2 == split.length) {
                    jSONObject2.put("location", "{\"longitude\":" + split[0] + ",\"latitude\":" + split[1] + "}");
                } else {
                    jSONObject2.put("location", "");
                }
            }
        }
        if (jSONObject.has("localIp")) {
            jSONObject2.put("localIp", PhoneUtils.getIpInfo() + "");
        }
        if (jSONObject.has("wifi")) {
            jSONObject2.put("wifi", NetUtils.getWifiSig(context, PhoneUtils.getCUID(context)));
        }
        if (jSONObject.has(WCP)) {
            try {
                if (!jSONObject2.has("wime")) {
                    jSONObject2.put("wime", "");
                }
                if (!jSONObject2.has("cuid_1")) {
                    jSONObject2.put("cuid_1", PhoneUtils.getCUID(context));
                }
                if (!jSONObject2.has("cuid_2")) {
                    jSONObject2.put("cuid_2", PhoneUtils.getCUID2(context));
                }
                if (!jSONObject2.has("nettype")) {
                    jSONObject2.put("nettype", NetworkUtils.getNetworkType(context));
                }
                if (!jSONObject2.has("wloc")) {
                    jSONObject2.put("wloc", PhoneUtils.getGPSLocation(context));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONObject.has(ROOT)) {
            try {
                if (!jSONObject2.has(ROOT)) {
                    jSONObject2.put(ROOT, SecurityUtils.isRoot());
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        String encodeToString = Base64Utils.encodeToString(jSONObject2.toString().getBytes());
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("data", encodeToString);
        jSONObject3.put(RouterCallback.KEY_ERROR_CODE, 0);
        jSONObject3.put("des", "ok");
        return LightappUtils.assembleResult(0, jSONObject3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        return PhoneUtils.getApplicationName(context) + "没有" + str;
    }

    private boolean a(String str, long j) {
        if (METHOD_CALL_QRCODE_SCANNER.equals(str)) {
            return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER).action("qrcodescanresult"));
        }
        if (METHOD_DETECT_BANKCARD.equals(str)) {
            return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("bankdetection").action("bankcarddetction"));
        }
        if (METHOD_DETECT_LIVENESS.equals(str)) {
            return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("livenessdetect").action("livenessdetect"));
        }
        if (METHOD_ACCESS_WALLET_SERVICE.equals(str)) {
            if (j == SVC_ID_H5_HOMEPAGE) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME).action("wallethome"));
            }
            if (j == SVC_ID_H5_BALANCE || j == SVC_ID_H5_TRANSERECORD || j == SVC_ID_H5_COUPON || j == SVC_ID_H5_MYBANKCARD || j == SVC_ID_H5_SECURITCENTER || j == SVC_ID_H5_CASHBACK) {
                return true;
            }
            if (j == SVC_ID_H5_CHARGE) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_FASTPAY).action("doPhoneCharge"));
            }
            if (j == SVC_ID_H5_TRANSFER) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_TRNASFER).action("entertransfer"));
            }
            if (j == SVC_ID_H5_SCANQR) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER).action("qrcodescanner"));
            }
            if (j == SVC_ID_H5_QRGEN) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("scancode").action("doScanCode"));
            }
            return j == SVC_ID_H5_CHECKPWD || j == SVC_ID_H5_PAY_SET || j == SVC_ID_H5_PWD_SET || j == -1;
        }
        return true;
    }
}
