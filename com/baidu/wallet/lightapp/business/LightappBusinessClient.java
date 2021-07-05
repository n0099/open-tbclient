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
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.rtc.SdpPrefer;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.log.ActLog;
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
/* loaded from: classes6.dex */
public class LightappBusinessClient implements ILightappInvoker {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static int f25339b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f25340c = 1;
    public static int q = -1;
    public static int r = -1;
    public static int s = -1;
    public static String t = null;
    public static int u = 1;
    public static int v = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.wallet.lightapp.multipage.a B;
    public ILightappInvokerCallback C;
    public HandlerThread D;
    public Handler E;
    public HashMap<String, b> F;
    public String G;

    /* renamed from: a  reason: collision with root package name */
    public String f25341a;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25342d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?> f25343e;

    /* renamed from: f  reason: collision with root package name */
    public Method f25344f;

    /* renamed from: g  reason: collision with root package name */
    public Class<?> f25345g;

    /* renamed from: h  reason: collision with root package name */
    public Class<?> f25346h;

    /* renamed from: i  reason: collision with root package name */
    public Method f25347i;
    public Class<?> j;
    public Class<?> k;
    public Method l;
    public Class<?> m;
    public String n;
    public ILightappInvokerCallback o;
    public String p;
    public boolean w;
    public boolean x;
    public boolean y;
    public final HashMap<String, ILightappInvokerCallback> z;

    /* renamed from: com.baidu.wallet.lightapp.business.LightappBusinessClient$12  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass12 implements RouterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ILightappInvokerCallback f25354a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f25355b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f25356c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LightappBusinessClient f25357d;

        public AnonymousClass12(LightappBusinessClient lightappBusinessClient, ILightappInvokerCallback iLightappInvokerCallback, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBusinessClient, iLightappInvokerCallback, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25357d = lightappBusinessClient;
            this.f25354a = iLightappInvokerCallback;
            this.f25355b = str;
            this.f25356c = context;
        }

        @Override // com.baidu.wallet.router.RouterCallback
        public void onResult(int i2, HashMap hashMap) {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                if (i2 == 0) {
                    if (hashMap == null || hashMap.size() <= 0 || (bundle = (Bundle) hashMap.get("result")) == null) {
                        return;
                    }
                    bundle.getInt(ShaderParams.VALUE_TYPE_STEP);
                    String string = bundle.getString("pic1");
                    String string2 = bundle.getString("pic2");
                    LightAppCallIDPhotoModel lightAppCallIDPhotoModel = new LightAppCallIDPhotoModel(0);
                    ImageBase64Utils imageBase64Utils = ImageBase64Utils.getInstance();
                    imageBase64Utils.getImageBase64(string, 640, new ImageBase64Utils.ImageBase64Listener(this, lightAppCallIDPhotoModel, string, string2, imageBase64Utils) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.12.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ LightAppCallIDPhotoModel f25358a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f25359b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f25360c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ ImageBase64Utils f25361d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass12 f25362e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, lightAppCallIDPhotoModel, string, string2, imageBase64Utils};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25362e = this;
                            this.f25358a = lightAppCallIDPhotoModel;
                            this.f25359b = string;
                            this.f25360c = string2;
                            this.f25361d = imageBase64Utils;
                        }

                        @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                        public void onBase64Result(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                this.f25358a.cnt.front = str;
                                this.f25361d.getImageBase64(this.f25360c, 640, new ImageBase64Utils.ImageBase64Listener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.12.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f25363a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f25363a = this;
                                    }

                                    @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                                    public void onBase64Result(String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                            AnonymousClass1 anonymousClass1 = this.f25363a;
                                            LightAppCallIDPhotoModel lightAppCallIDPhotoModel2 = anonymousClass1.f25358a;
                                            lightAppCallIDPhotoModel2.cnt.back = str2;
                                            anonymousClass1.f25362e.f25354a.onResult(0, lightAppCallIDPhotoModel2.toJson());
                                            try {
                                                if (this.f25363a.f25359b != null) {
                                                    File file = new File(this.f25363a.f25359b);
                                                    if (file.exists()) {
                                                        file.delete();
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                            try {
                                                if (this.f25363a.f25360c != null) {
                                                    File file2 = new File(this.f25363a.f25360c);
                                                    if (file2.exists()) {
                                                        file2.delete();
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th2.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    });
                } else if (i2 == 1) {
                    if (hashMap == null || hashMap.size() <= 0) {
                        return;
                    }
                    int intValue = ((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue();
                    String str = (String) hashMap.get("errMsg");
                    if (intValue == -1) {
                        LightappUtils.onError(this.f25354a, this.f25355b, LightappConstants.ERRCODE_NO_PERMISSION, this.f25357d.a(this.f25356c, "访问相机的权限"), "#callIDPotosFail");
                    } else if (-2 == intValue) {
                        LightappUtils.onError(this.f25354a, this.f25355b, LightappConstants.ERRCODE_CANCEL, "取消", "#callIDPotosFail");
                    }
                } else {
                    String str2 = (String) hashMap.get("errorMsg");
                    ILightappInvokerCallback iLightappInvokerCallback = this.f25354a;
                    String str3 = this.f25355b;
                    String num = Integer.toString(i2);
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str3, num, str2, "#callIDPotosFail");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f25438a;

        /* renamed from: b  reason: collision with root package name */
        public int f25439b;

        /* renamed from: c  reason: collision with root package name */
        public int f25440c;

        /* renamed from: d  reason: collision with root package name */
        public int f25441d;

        /* renamed from: e  reason: collision with root package name */
        public ILightappInvokerCallback f25442e;

        /* renamed from: f  reason: collision with root package name */
        public String f25443f;

        /* renamed from: g  reason: collision with root package name */
        public String f25444g;

        /* renamed from: h  reason: collision with root package name */
        public String f25445h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ LightappBusinessClient f25446i;

        public a(LightappBusinessClient lightappBusinessClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBusinessClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25446i = lightappBusinessClient;
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f25447a;

        /* renamed from: b  reason: collision with root package name */
        public String f25448b;

        /* renamed from: c  reason: collision with root package name */
        public ILightappInvokerCallback f25449c;

        /* renamed from: d  reason: collision with root package name */
        public String f25450d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LightappBusinessClient f25451e;

        public b(LightappBusinessClient lightappBusinessClient, Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappBusinessClient, context, str, iLightappInvokerCallback, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25451e = lightappBusinessClient;
            this.f25447a = context;
            this.f25448b = str;
            this.f25449c = iLightappInvokerCallback;
            this.f25450d = str2;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ILightappInvokerCallback f25452a;

        public c(ILightappInvokerCallback iLightappInvokerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iLightappInvokerCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25452a = iLightappInvokerCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                if (this.f25452a != null) {
                    if ("onResult".equals(method.getName())) {
                        if (objArr != null && objArr.length >= 2) {
                            this.f25452a.onResult(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                        }
                        return null;
                    }
                    return method.invoke(this.f25452a, objArr);
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1678336910, "Lcom/baidu/wallet/lightapp/business/LightappBusinessClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1678336910, "Lcom/baidu/wallet/lightapp/business/LightappBusinessClient;");
        }
    }

    public LightappBusinessClient(com.baidu.wallet.lightapp.multipage.a aVar) {
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
        this.f25341a = LightappBusinessClient.class.getSimpleName();
        this.f25342d = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = new HashMap<>();
        this.C = null;
        this.E = null;
        this.F = null;
        this.B = aVar;
        HandlerThread handlerThread = new HandlerThread("LangbridgeThread");
        this.D = handlerThread;
        handlerThread.start();
        this.E = new Handler(this, this.D.getLooper()) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LightappBusinessClient f25348a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f25348a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (1 == i4) {
                        this.f25348a.a((a) message.obj);
                    } else if (2 == i4) {
                        this.f25348a.b((a) message.obj);
                    }
                }
            }
        };
    }

    private long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
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
        return invokeJ.longValue;
    }

    private void h(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65582, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                HashMap hashMap = (HashMap) JsonUtils.fromJson(new JSONObject(str).getString("dxmPayLiveness"), HashMap.class);
                PayStatisticsUtil.onEventWithValue("#identifyAuth", CheckUtils.stripUrlParams(str2));
                if (LocalRouter.getInstance(context).isProviderExisted("livenessidentifyauth")) {
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("livenessidentifyauth").action("livenessidentifyauth").data(hashMap), new RouterCallback(this, iLightappInvokerCallback, str2, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ILightappInvokerCallback f25427a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f25428b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Context f25429c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ LightappBusinessClient f25430d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iLightappInvokerCallback, str2, context};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25430d = this;
                            this.f25427a = iLightappInvokerCallback;
                            this.f25428b = str2;
                            this.f25429c = context;
                        }

                        @Override // com.baidu.wallet.router.RouterCallback
                        public void onResult(int i2, HashMap hashMap2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) {
                                if (i2 != 0) {
                                    if (i2 == 5) {
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put("provider", "livenessidentifyauth");
                                        hashMap3.put("action", "livenessidentifyauth");
                                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                                        return;
                                    }
                                    LightappUtils.onError(this.f25427a, this.f25428b, i2 + "", PhoneUtils.getApplicationName(this.f25429c) + ((String) hashMap2.get("errorMsg")), "#identifyAuthFail");
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
                                        this.f25427a.onResult(0, lightAppCommonModel.toJson());
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                        LightappUtils.onError(this.f25427a, this.f25428b, i2 + "", PhoneUtils.getApplicationName(this.f25429c) + ((String) hashMap2.get("errorMsg")), "#identifyAuthFail");
                                    }
                                }
                            }
                        }
                    });
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void i(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65583, this, context, str, iLightappInvokerCallback, str2) == null) {
            Set<String> methodList = LightAppWrapper.getInstance().getMethodList();
            if (methodList != null && methodList.contains("callNativeVoice")) {
                LightAppWrapper.getInstance().lightappInvoke(context, str, iLightappInvokerCallback);
            } else {
                WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(context, new ILoginBackListener(this, iLightappInvokerCallback, str2, str, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ILightappInvokerCallback f25431a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f25432b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f25433c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Context f25434d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f25435e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iLightappInvokerCallback, str2, str, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25435e = this;
                        this.f25431a = iLightappInvokerCallback;
                        this.f25432b = str2;
                        this.f25433c = str;
                        this.f25434d = context;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                            LightappUtils.onError(this.f25431a, this.f25432b, String.valueOf(101), "请重新登录!", "#callNativeVoiceFail");
                        }
                    }

                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, CONSTRUCTOR, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                            if (!this.f25435e.w) {
                                try {
                                    this.f25435e.f25343e = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                                    this.f25435e.f25345g = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                                    this.f25435e.f25344f = this.f25435e.f25343e.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, Context.class, String.class, Boolean.TYPE, this.f25435e.f25345g);
                                } finally {
                                    try {
                                    } finally {
                                    }
                                }
                            }
                            if (this.f25435e.f25343e != null && this.f25435e.f25345g != null && this.f25435e.f25344f != null) {
                                try {
                                    Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f25435e.f25345g}, new c(this.f25431a));
                                    boolean equals = "ONLINE".equals(DebugConfig.getInstance().getEnvironment());
                                    JSONObject jSONObject = new JSONObject(this.f25433c);
                                    jSONObject.put("stoken", WalletLoginHelper.getInstance().getLoginStoken());
                                    this.f25435e.f25344f.invoke(null, this.f25434d, jSONObject.toString(), Boolean.valueOf(equals), newProxyInstance);
                                    return;
                                } catch (Throwable unused) {
                                    LightappUtils.onError(this.f25431a, this.f25432b, LightappConstants.ERRCODE_INNER_ERROR, "reflect callNativeVoice fail!", "#callNativeVoiceFail");
                                    return;
                                }
                            }
                            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                            data.errCode = "10004";
                            data.des = "没有找到对应的方法";
                            this.f25431a.onResult(1, lightAppErrorModel.toJson());
                        }
                    }
                }));
            }
        }
    }

    private void j(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65584, this, context, str, iLightappInvokerCallback, str2) == null) || CheckUtils.isFastDoubleClick()) {
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
            BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new BaiduWalletUtils.IRequestPermissionCallBack(this, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f25436a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f25437b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25437b = this;
                    this.f25436a = str2;
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        if (bool.booleanValue()) {
                            PermissionManager.checkCallingOrSelfPermission(this.f25437b.B.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 245);
                        } else {
                            this.f25437b.onRequestPermissionsResult(this.f25436a, 245, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new int[]{-1, -1});
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, CONST_STR, INVOKE, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, IPUT, MOVE_EXCEPTION] complete} */
    private void k(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65585, this, context, str, iLightappInvokerCallback, str2) == null) {
            if (!this.x) {
                try {
                    this.f25346h = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessManager");
                    Class<?> cls = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessCallback");
                    this.j = cls;
                    this.f25347i = this.f25346h.getDeclaredMethod("startDetact", Context.class, String.class, cls);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            if (this.f25346h != null && this.j != null && this.f25347i != null) {
                try {
                    this.f25347i.invoke(null, context, str, Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.j}, new c(iLightappInvokerCallback)));
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
    }

    private void l(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65586, this, context, str, iLightappInvokerCallback, str2) == null) {
            if (PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) && PermissionManager.checkCallingPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                m(context, str, iLightappInvokerCallback, str2);
            } else {
                PermissionManager.checkCallingOrSelfPermission(getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 246);
            }
        }
    }

    private void m(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65587, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    private void n(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65588, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
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

    private void o(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65589, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                    BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, getActivity(), new String[]{"android.permission.READ_CONTACTS"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f25349a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LightappBusinessClient f25350b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25350b = this;
                            this.f25349a = str2;
                        }

                        @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                        public void isAllAgree(Boolean bool) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                if (bool.booleanValue()) {
                                    if (PermissionManager.checkCallingOrSelfPermission(this.f25350b.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK)) {
                                        return;
                                    }
                                    this.f25350b.a(this.f25349a);
                                    return;
                                }
                                this.f25350b.onRequestPermissionsResult("", LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, new String[]{"android.permission.READ_CONTACTS"}, new int[]{-1});
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

    private void p(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65590, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    private void q(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65591, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    private void r(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65592, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(jSONArray.getString(i2));
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
    }

    private void s(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65593, this, context, str, iLightappInvokerCallback, str2) == null) {
            PayStatisticsUtil.onEventWithValue("#openInBrowser", CheckUtils.stripUrlParams(str2));
            try {
                if (!TextUtils.isEmpty(str2)) {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                    LogUtil.i(this.f25341a, "Open in Browser Success");
                    if (iLightappInvokerCallback != null) {
                        iLightappInvokerCallback.onResult(0, "");
                    }
                } else if (iLightappInvokerCallback != null) {
                    LogUtil.i(this.f25341a, "Open in Browser fail");
                    iLightappInvokerCallback.onResult(1, "url为空");
                }
            } catch (Exception e2) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#openInBrowserFail");
            }
        }
    }

    private void t(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65594, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    private void u(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65595, this, context, str, iLightappInvokerCallback, str2) == null) {
            PayStatisticsUtil.onEventWithValue("#onBDWalletPageGoBack", CheckUtils.stripUrlParams(str2));
            setH5BackCb(iLightappInvokerCallback);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        JSONObject jSONObject;
        LightappBusinessClient lightappBusinessClient;
        Context context2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65596, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
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
                for (int i3 = 0; i3 < 10; i3++) {
                    jSONObject3.put(strArr[i3], "1");
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
            i2 = 0;
        } catch (Exception e3) {
            e = e3;
            try {
                jSONObject2.put("data", Base64Utils.encodeToString(new JSONObject().toString().getBytes()));
                jSONObject2.put(RouterCallback.KEY_ERROR_CODE, 1);
                jSONObject2.put("des", "exception." + e.getMessage());
                str3 = LightappUtils.assembleResult(1, jSONObject2);
                i2 = 1;
            } catch (Exception unused) {
                i2 = 1;
                z = true;
            }
            if (z) {
            }
            iLightappInvokerCallback.onResult(i2, str3);
            if (i2 == 0) {
            }
        }
        if (z) {
            str3 = LightappUtils.assembleResult(1, jSONObject2);
        }
        iLightappInvokerCallback.onResult(i2, str3);
        if (i2 == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(CheckUtils.stripUrlParams(str2));
            arrayList.add(str3);
            PayStatisticsUtil.onEventWithValues("#callPhoneInfoFail", arrayList);
        }
    }

    private void w(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65597, this, context, str, iLightappInvokerCallback, str2) == null) {
            PayStatisticsUtil.onEventWithValue("#callNativePhoto", CheckUtils.stripUrlParams(str2));
            this.p = str;
            if (!PermissionManager.checkCallingPermission(this.B.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, this.B.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f25373a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f25374b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25374b = this;
                        this.f25373a = str2;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                PermissionManager.checkCallingOrSelfPermission(this.f25374b.B.getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
                            } else {
                                this.f25374b.onRequestPermissionsResult(this.f25373a, 4, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new int[]{-1});
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
            } else {
                this.B.loadAlubm(str);
            }
        }
    }

    private void x(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65598, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:3|(2:4|5)|(6:10|11|12|13|14|(2:16|17)(1:19))|24|11|12|13|14|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
        r6.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(65599, this, context, str, iLightappInvokerCallback, str2) != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contacts", PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS"));
            jSONObject.put("location", PermissionManager.checkCallingPermission(context, "android.permission.ACCESS_FINE_LOCATION"));
            jSONObject.put("camera", PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65600, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                        linkedHashMap.put("filename", jSONObject.optString("filename"));
                        linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(optString3).toString());
                        Tracker.send(optString, linkedHashMap, context, optString2);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#uploadMsgFail");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[Catch: Exception -> 0x009b, TRY_ENTER, TryCatch #2 {Exception -> 0x009b, blocks: (B:22:0x0034, B:25:0x0047, B:27:0x004b, B:29:0x0055, B:31:0x0059, B:35:0x0073, B:36:0x0084), top: B:47:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b A[Catch: Exception -> 0x009b, TryCatch #2 {Exception -> 0x009b, blocks: (B:22:0x0034, B:25:0x0047, B:27:0x004b, B:29:0x0055, B:31:0x0059, B:35:0x0073, B:36:0x0084), top: B:47:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void accessWalletService(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        String str4;
        long parseLong;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                    eventBus.postStickyEvent(new EventBus.Event(eventBus, H5BanlanceCallback, iLightappInvokerCallback));
                }
                BaiduWalletServiceController baiduWalletServiceController = BaiduWalletServiceController.getInstance();
                baiduWalletServiceController.gotoWalletService(context, a2 + "", str4, iLightappInvokerCallback);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public void bdLogin(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, iLightappInvokerCallback, str2) == null) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_BD_LOGIN, CheckUtils.stripUrlParams(str2));
            try {
                str3 = new JSONObject(str).optString("extra_param");
            } catch (JSONException unused) {
                str3 = "";
            }
            WalletLoginHelper.getInstance().onlyLogin(new LoginBackListenerProxy(context, new ILoginBackListener(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f25402a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25403b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f25404c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLightappInvokerCallback, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25404c = this;
                    this.f25402a = iLightappInvokerCallback;
                    this.f25403b = str2;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str4) == null) {
                        LightappUtils.onError(this.f25402a, this.f25403b, Integer.toString(i2), str4, "#bdLoginFail");
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str4) == null) {
                        this.f25402a.onResult(0, "0");
                    }
                }
            }), str3);
        }
    }

    public void callCamera(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, iLightappInvokerCallback, str2) == null) {
            a(METHOD_CALL_CAMERA, str);
            int parseJsonInt = LightappUtils.parseJsonInt(str, "type");
            ArrayList arrayList = new ArrayList();
            arrayList.add(CheckUtils.stripUrlParams(str2));
            arrayList.add("" + parseJsonInt);
            PayStatisticsUtil.onEventWithValues("#callCamera", arrayList);
            if (1 == parseJsonInt) {
                try {
                    i2 = (int) (new JSONObject(str).optDouble("quality") * 100.0d);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i2 = -1;
                }
                IdCardDetectionController.getInstance().startIdcarddetect(context, 6, new IdCardDetectionController.IIdCardDetectionListener(this, iLightappInvokerCallback, (i2 <= 0 || 100 < i2) ? -1 : i2, context, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ILightappInvokerCallback f25375a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f25376b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Context f25377c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f25378d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f25379e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iLightappInvokerCallback, Integer.valueOf(r8), context, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25379e = this;
                        this.f25375a = iLightappInvokerCallback;
                        this.f25376b = r8;
                        this.f25377c = context;
                        this.f25378d = str2;
                    }

                    @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
                    public void onDetectFailed(int i3, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str3) == null) {
                            if (i3 != -1) {
                                if (i3 == -2) {
                                    LightappUtils.onError(this.f25375a, this.f25378d, LightappConstants.ERRCODE_CANCEL, "取消", "#callCameraFail");
                                    return;
                                }
                                return;
                            }
                            LightAppTakePictureModel lightAppTakePictureModel = new LightAppTakePictureModel(1);
                            LightAppTakePictureModel.Data data = lightAppTakePictureModel.cnt;
                            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
                            data.des = PhoneUtils.getApplicationName(this.f25377c) + "没有访问相机的权限";
                            this.f25375a.onResult(1, lightAppTakePictureModel.toJson());
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(CheckUtils.stripUrlParams(this.f25378d));
                            arrayList2.add("1:" + str3);
                            PayStatisticsUtil.onEventWithValues("#callCameraFail", arrayList2);
                        }
                    }

                    @Override // com.baidu.wallet.base.controllers.IdCardDetectionController.IIdCardDetectionListener
                    public void onDetectOK(Bundle bundle) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                            if (bundle == null) {
                                ILightappInvokerCallback iLightappInvokerCallback2 = this.f25375a;
                                if (iLightappInvokerCallback2 != null) {
                                    iLightappInvokerCallback2.onResult(1, "internal error");
                                    return;
                                }
                                return;
                            }
                            String string = bundle.getString("pic1");
                            ImageBase64Utils.ImageBase64Listener imageBase64Listener = new ImageBase64Utils.ImageBase64Listener(this, new LightAppTakePictureModel(0)) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.17.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ LightAppTakePictureModel f25380a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass17 f25381b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r7};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f25381b = this;
                                    this.f25380a = r7;
                                }

                                @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                                public void onBase64Result(String str3) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, str3) == null) {
                                        LightAppTakePictureModel lightAppTakePictureModel = this.f25380a;
                                        lightAppTakePictureModel.cnt.image = str3;
                                        this.f25381b.f25375a.onResult(0, lightAppTakePictureModel.toJson());
                                    }
                                }
                            };
                            ImageBase64Utils imageBase64Utils = ImageBase64Utils.getInstance();
                            int i3 = this.f25376b;
                            if (i3 > 0) {
                                imageBase64Utils.getImageBase64(string, -1, i3, imageBase64Listener);
                            } else {
                                imageBase64Utils.getImageBase64(string, 640, imageBase64Listener);
                            }
                        }
                    }
                }, false);
                return;
            }
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + parseJsonInt, "#callCameraFail");
        }
    }

    public void callIDPotos(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, iLightappInvokerCallback, str2) == null) {
            a(METHOD_CALL_ID_PHOTOS, str);
            int parseJsonInt = LightappUtils.parseJsonInt(str, "type");
            int i2 = 1 == parseJsonInt ? 1 : 2 == parseJsonInt ? 3 : 3 == parseJsonInt ? 4 : 4 == parseJsonInt ? 5 : 5 == parseJsonInt ? 6 : -1;
            if (i2 > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(CheckUtils.stripUrlParams(str2));
                arrayList.add("" + i2);
                PayStatisticsUtil.onEventWithValues(StatServiceEvent.LIGHT_APP_EVENTID_CALL_ID_PHOTOS, arrayList);
                a(context, i2, iLightappInvokerCallback, str2, LightappUtils.parseJsonInt(str, "showalbum") == 1);
                return;
            }
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + i2, "#callIDPotosFail");
        }
    }

    public void callQRCodeScanner(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, iLightappInvokerCallback, str2) == null) {
            PayStatisticsUtil.onEventWithValue("#callQRCodeScanner", CheckUtils.stripUrlParams(str2));
            if (LightappUtils.parseJsonInt(str, "needScanResult") == f25340c) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER).action("qrcodescanresult"), new RouterCallback(this, iLightappInvokerCallback, str2, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ILightappInvokerCallback f25411a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f25412b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Context f25413c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f25414d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iLightappInvokerCallback, str2, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25414d = this;
                        this.f25411a = iLightappInvokerCallback;
                        this.f25412b = str2;
                        this.f25413c = context;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                            if (i2 == 0 && hashMap != null) {
                                String str3 = (String) hashMap.get("value");
                                LightAppCallQRCodeScannerModel lightAppCallQRCodeScannerModel = new LightAppCallQRCodeScannerModel();
                                lightAppCallQRCodeScannerModel.result = 0;
                                if (!TextUtils.isEmpty(str3)) {
                                    lightAppCallQRCodeScannerModel.cnt.scanResult = Base64.encodeToString(str3.getBytes(), 2);
                                }
                                this.f25411a.onResult(0, lightAppCallQRCodeScannerModel.toJson());
                            } else if (i2 == 5) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER);
                                hashMap2.put("action", "qrcodescanresult");
                                DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                                PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                            } else if (i2 != 1 || hashMap == null) {
                            } else {
                                int intValue = ((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue();
                                String str4 = (String) hashMap.get("errorMsg");
                                if (intValue == 2 && TextUtils.equals(str4, "camera_permission_denied")) {
                                    LightappUtils.onError(this.f25411a, this.f25412b, LightappConstants.ERRCODE_NO_PERMISSION, this.f25414d.a(this.f25413c, "访问相机的权限"), "#callQRCodeScannerFail");
                                } else if (intValue == 0) {
                                    LightappUtils.onError(this.f25411a, this.f25412b, LightappConstants.ERRCODE_CANCEL, "取消", "#callQRCodeScannerFail");
                                }
                            }
                        }
                    }
                });
            }
            BaiduWalletServiceController.getInstance().gotoWalletService(context, "32768", "");
        }
    }

    public void changePayMethod(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
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
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterChangePayMethod").data("options", str), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ILightappInvokerCallback f25367a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f25368b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LightappBusinessClient f25369c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iLightappInvokerCallback, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25369c = this;
                this.f25367a = iLightappInvokerCallback;
                this.f25368b = str2;
            }

            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                    if (i2 == 0) {
                        if (hashMap == null || hashMap.size() <= 0) {
                            return;
                        }
                        String str3 = (String) hashMap.get("result");
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        try {
                            if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                                this.f25367a.onResult(0, str3);
                            } else {
                                this.f25367a.onResult(1, str3);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(CheckUtils.stripUrlParams(this.f25368b));
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
                    ILightappInvokerCallback iLightappInvokerCallback2 = this.f25367a;
                    String str5 = this.f25368b;
                    String num = Integer.toString(i2);
                    if (TextUtils.isEmpty(str4)) {
                        str4 = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    LightappUtils.onError(iLightappInvokerCallback2, str5, num, str4, "#changePayMethodFail");
                }
            }
        });
    }

    public void checkPermission() {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String str = this.G;
            int hashCode = str.hashCode();
            if (hashCode == -1367751899) {
                if (str.equals("camera")) {
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
    }

    public void detectBankCard(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, context, str, iLightappInvokerCallback, str2) == null) {
            a(METHOD_DETECT_BANKCARD, str);
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_DETECT_BANKCARD, CheckUtils.stripUrlParams(str2));
            if (LocalRouter.getInstance(context).isProviderExisted("bankdetection")) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback(this, iLightappInvokerCallback, str2, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ILightappInvokerCallback f25386a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f25387b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Context f25388c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f25389d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iLightappInvokerCallback, str2, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f25389d = this;
                        this.f25386a = iLightappInvokerCallback;
                        this.f25387b = str2;
                        this.f25388c = context;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                            if (i2 == 0) {
                                if (hashMap == null || TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                                    return;
                                }
                                String str3 = (String) hashMap.get("card_num");
                                if (TextUtils.isEmpty(str3)) {
                                    return;
                                }
                                LightAppDetectBankcardModel lightAppDetectBankcardModel = new LightAppDetectBankcardModel(0);
                                lightAppDetectBankcardModel.cnt.data = str3;
                                this.f25386a.onResult(0, lightAppDetectBankcardModel.toJson());
                            } else if (i2 != 1 || hashMap == null) {
                                if (i2 == 5) {
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("provider", "bankdetection");
                                    hashMap2.put("action", "bankcarddetction");
                                    DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                                }
                            } else if (((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue() == -1) {
                                ILightappInvokerCallback iLightappInvokerCallback2 = this.f25386a;
                                String str4 = this.f25387b;
                                LightappUtils.onError(iLightappInvokerCallback2, str4, LightappConstants.ERRCODE_NO_PERMISSION, PhoneUtils.getApplicationName(this.f25388c) + "没有访问相机的权限", "#detectBankCardFail");
                            } else if (((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue() == -2) {
                                LightappUtils.onError(this.f25386a, this.f25387b, LightappConstants.ERRCODE_CANCEL, "取消", "#detectBankCardFail");
                            }
                        }
                    }
                });
            }
        }
    }

    public void detectLiveness(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, iLightappInvokerCallback, str2) == null) {
            a("detectLiveness", str);
            try {
                HashMap hashMap = (HashMap) JsonUtils.fromJson(str, HashMap.class);
                PayStatisticsUtil.onEventWithValue("#faceRegister", CheckUtils.stripUrlParams(str2));
                if (LocalRouter.getInstance(context).isProviderExisted("livenessdetect")) {
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("livenessdetect").action("livenessdetect").data(hashMap), new RouterCallback(this, iLightappInvokerCallback, str2, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.18
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ILightappInvokerCallback f25382a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f25383b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Context f25384c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ LightappBusinessClient f25385d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iLightappInvokerCallback, str2, context};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25385d = this;
                            this.f25382a = iLightappInvokerCallback;
                            this.f25383b = str2;
                            this.f25384c = context;
                        }

                        @Override // com.baidu.wallet.router.RouterCallback
                        public void onResult(int i2, HashMap hashMap2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) {
                                if (i2 == 0) {
                                    if (hashMap2 != null) {
                                        Object obj = hashMap2.get("value");
                                        if (obj instanceof JSONObject) {
                                            try {
                                                LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(0);
                                                lightAppCommonModel.cnt.data = (HashMap) JsonUtils.fromJson(((JSONObject) obj).toString(), HashMap.class);
                                                this.f25382a.onResult(0, lightAppCommonModel.toJson());
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                } else if (i2 == 5) {
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("provider", "livenessdetect");
                                    hashMap3.put("action", "livenessdetect");
                                    DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap3.values());
                                } else {
                                    LightappUtils.onError(this.f25382a, this.f25383b, i2 + "", PhoneUtils.getApplicationName(this.f25384c) + ((String) hashMap2.get("errorMsg")), "#faceRegisterFail");
                                }
                            }
                        }
                    });
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void doBindCard(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, context, str, iLightappInvokerCallback, str2, str3) == null) {
            if (TextUtils.isEmpty(str3)) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_BINDCARD, CheckUtils.stripUrlParams(str2));
            }
            String str4 = "";
            this.f25342d = false;
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
                        this.f25342d = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterDoInnerBind").data("showDialog", Boolean.valueOf(this.f25342d)).data("orderInfo", str4), new RouterCallback(this, iLightappInvokerCallback, str2, str3) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f25398a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25399b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f25400c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f25401d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLightappInvokerCallback, str2, str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25401d = this;
                    this.f25398a = iLightappInvokerCallback;
                    this.f25399b = str2;
                    this.f25400c = str3;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0) {
                            if (hashMap == null || hashMap.size() <= 0) {
                                return;
                            }
                            int intValue = ((Integer) hashMap.get("statusCode")).intValue();
                            String str5 = (String) hashMap.get("params");
                            if (intValue == 0) {
                                this.f25398a.onResult(0, str5);
                                return;
                            }
                            ILightappInvokerCallback iLightappInvokerCallback2 = this.f25398a;
                            String str6 = this.f25399b;
                            StringBuilder sb = new StringBuilder();
                            sb.append("#");
                            sb.append(TextUtils.isEmpty(this.f25400c) ? LightappBusinessClient.METHOD_DO_BIND_CARD : this.f25400c);
                            sb.append(ActLog.TYPE_FAIL);
                            LightappUtils.onError(iLightappInvokerCallback2, str6, LightappConstants.ERRCODE_CANCEL, str5, sb.toString());
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(CheckUtils.stripUrlParams(this.f25399b));
                            arrayList.add(str5);
                            PayStatisticsUtil.onEventWithValues("#doBindCardFail", arrayList);
                            return;
                        }
                        String str7 = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback3 = this.f25398a;
                        String str8 = this.f25399b;
                        String num = Integer.toString(i2);
                        if (!TextUtils.isEmpty(str7)) {
                            str7 = LightappConstants.ROUTER_INVOKE_FAIL;
                        }
                        LightappUtils.onError(iLightappInvokerCallback3, str8, num, str7, "#doBindCardFail");
                    }
                }
            });
        }
    }

    public void doRnAuth(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, context, str, iLightappInvokerCallback, str2) == null) {
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
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterDoRnAuth").data(getUrlParam(str3)), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f25405a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25406b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f25407c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLightappInvokerCallback, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25407c = this;
                    this.f25405a = iLightappInvokerCallback;
                    this.f25406b = str2;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0) {
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
                                this.f25405a.onResult(0, jSONObject.toString());
                                return;
                            }
                            LightappUtils.onError(this.f25405a, this.f25406b, Integer.toString(intValue), str4, "#doRnAuthFail");
                            return;
                        }
                        String str5 = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback2 = this.f25405a;
                        String str6 = this.f25406b;
                        String num = Integer.toString(i2);
                        if (!TextUtils.isEmpty(str5)) {
                            str5 = LightappConstants.ROUTER_INVOKE_FAIL;
                        }
                        LightappUtils.onError(iLightappInvokerCallback2, str6, num, str5, "#doRnAuthFail");
                    }
                }
            });
        }
    }

    public void dopay(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, context, str, iLightappInvokerCallback, str2) == null) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_BD_DOPAY, CheckUtils.stripUrlParams(str2));
            this.f25342d = false;
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
                        this.f25342d = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterDoPayWithParams").data("orderInfo", str3).data("showDialog", Boolean.valueOf(this.f25342d)), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f25395a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25396b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f25397c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLightappInvokerCallback, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25397c = this;
                    this.f25395a = iLightappInvokerCallback;
                    this.f25396b = str2;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0) {
                            if (hashMap == null || hashMap.size() <= 0) {
                                return;
                            }
                            int intValue = ((Integer) hashMap.get("statusCode")).intValue();
                            String str4 = (String) hashMap.get("payDesc");
                            if (intValue != 0 && intValue != 1) {
                                this.f25395a.onResult(1, str4);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(CheckUtils.stripUrlParams(this.f25396b));
                                arrayList.add(str4);
                                PayStatisticsUtil.onEventWithValues("#dopayFail", arrayList);
                                return;
                            }
                            this.f25395a.onResult(0, str4);
                            return;
                        }
                        String str5 = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback2 = this.f25395a;
                        String str6 = this.f25396b;
                        String num = Integer.toString(i2);
                        if (!TextUtils.isEmpty(str5)) {
                            str5 = LightappConstants.ROUTER_INVOKE_FAIL;
                        }
                        LightappUtils.onError(iLightappInvokerCallback2, str6, num, str5, "#dopayFail");
                    }
                }
            });
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            com.baidu.wallet.lightapp.multipage.a aVar = this.B;
            if (aVar != null) {
                return aVar.getActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public ILightappInvokerCallback getH5BackCb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.C : (ILightappInvokerCallback) invokeV.objValue;
    }

    public void getLoadTimeLine(ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, iLightappInvokerCallback) == null) || iLightappInvokerCallback == null) {
            return;
        }
        String loadTimeLine = this.B.getLoadTimeLine();
        String str = this.f25341a;
        LogUtil.d(str, "getLoadTimeLine result = " + loadTimeLine);
        iLightappInvokerCallback.onResult(0, loadTimeLine);
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        return (Set) invokeV.objValue;
    }

    public void getOfflineCacheInfo(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048593, this, context, str, iLightappInvokerCallback, str2) == null) {
            JSONObject offlineCacheInfo = LangbridgeCacheManager.getInstance().getOfflineCacheInfo(str2);
            if (offlineCacheInfo == null) {
                offlineCacheInfo = new JSONObject();
            }
            iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, offlineCacheInfo));
        }
    }

    public void getPayMethod(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048594, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValue("#getPayMethod", CheckUtils.stripUrlParams(str2));
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterGetPayMethod").data("options", str), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ILightappInvokerCallback f25364a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f25365b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LightappBusinessClient f25366c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iLightappInvokerCallback, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25366c = this;
                this.f25364a = iLightappInvokerCallback;
                this.f25365b = str2;
            }

            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) || i2 != 0 || hashMap == null || hashMap.size() <= 0) {
                    return;
                }
                String str3 = (String) hashMap.get("result");
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                try {
                    if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                        this.f25364a.onResult(0, str3);
                        return;
                    }
                    this.f25364a.onResult(1, str3);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(CheckUtils.stripUrlParams(this.f25365b));
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
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
        return (HashMap) invokeL.objValue;
    }

    public void getSupportedMethodList(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048596, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
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
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
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
        return (HashMap) invokeL.objValue;
    }

    public void getUserAgent(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048598, this, context, str, iLightappInvokerCallback, str2) == null) {
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.LIGHT_APP_EVENTID_GET_UA, CheckUtils.stripUrlParams(str2));
            String ua = BussinessUtils.getUA(context);
            if (LightappUtils.parseJsonInt(str, "base64") == f25339b) {
                ua = Base64.encodeToString(ua.getBytes(), 2);
            }
            LightAppUserAgentModel lightAppUserAgentModel = new LightAppUserAgentModel(0);
            lightAppUserAgentModel.cnt.data = ua;
            iLightappInvokerCallback.onResult(0, lightAppUserAgentModel.toJson());
        }
    }

    public void initpay(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048599, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, context, str, iLightappInvokerCallback) == null) {
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
    }

    public void login(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, str3) == null) {
            LogUtil.d("bdLogin. options = " + str + ", success = " + str2 + ", fail = " + str3);
        }
    }

    public void onContactsSelected(String str, int i2, String[] strArr, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, Integer.valueOf(i2), strArr, str2, str3}) == null) {
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
                    PhoneContactsMananger.a(getActivity()).a(new PhoneContactsMananger.d(this, contactSelectModel, str3) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ContactSelectModel f25351a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f25352b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ LightappBusinessClient f25353c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, contactSelectModel, str3};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f25353c = this;
                            this.f25351a = contactSelectModel;
                            this.f25352b = str3;
                        }

                        @Override // com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger.d
                        public void a(List<ContactSelectModel.AllContact> list, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, list, i3) == null) {
                                if (LightappBusinessClient.t != null) {
                                    this.f25351a.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), LightappBusinessClient.t));
                                    if (TextUtils.isEmpty(this.f25352b)) {
                                        this.f25351a.cnt.allCount = "0";
                                    } else {
                                        this.f25351a.cnt.allCount = this.f25352b;
                                    }
                                } else {
                                    this.f25351a.cnt.all = list;
                                    if (TextUtils.isEmpty(this.f25352b)) {
                                        this.f25351a.cnt.allCount = "0";
                                    } else if (list != null) {
                                        ContactSelectModel.Data data2 = this.f25351a.cnt;
                                        data2.allCount = list.size() + "";
                                    } else {
                                        this.f25351a.cnt.allCount = this.f25352b;
                                    }
                                }
                                if (LightappBusinessClient.s != LightappBusinessClient.A) {
                                    this.f25353c.a("selectPhonefromAdressBook", 0, this.f25351a.toJson());
                                    return;
                                }
                                LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                                ContactSelectModel contactSelectModel2 = this.f25351a;
                                lightAppContactSelectModelBase64.result = contactSelectModel2.result;
                                ContactSelectModel.Data data3 = contactSelectModel2.cnt;
                                if (data3 != null) {
                                    lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data3).getBytes());
                                }
                                this.f25353c.a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
                            }
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
    }

    public void onRequestPermissionsResult(String str, int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048603, this, str, i2, strArr, iArr) == null) {
            int i3 = 0;
            if (244 == i2) {
                b bVar = this.F.get(MTD_START_AUDIO_RECORD);
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    while (i3 < strArr.length) {
                        if (PermissionRequest.RESOURCE_AUDIO_CAPTURE.equals(strArr[i3])) {
                            if (bVar != null) {
                                b(bVar.f25447a, bVar.f25448b, bVar.f25449c, bVar.f25450d);
                                return;
                            }
                            return;
                        }
                        i3++;
                    }
                    return;
                }
                LightappUtils.onError(bVar != null ? bVar.f25449c : null, str, LightappConstants.ERRCODE_NO_PERMISSION, "无录音权限", "startRecordingFail");
            } else if (243 == i2) {
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    while (i3 < strArr.length) {
                        if ("android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i3])) {
                            if (i3 < iArr.length) {
                                int i4 = iArr[i3];
                                if (i4 != 0) {
                                    if (i4 == -1) {
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
                        i3++;
                    }
                    return;
                }
                a(str);
            } else if (245 != i2 && 246 != i2) {
                if (i2 == 4) {
                    if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                        while (i3 < strArr.length) {
                            if ("android.permission.READ_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i3]) && i3 < iArr.length && iArr[i3] == -1) {
                                b(MTD_CALL_NATIVE_PHOTO, "没有存储权限");
                                return;
                            }
                            i3++;
                        }
                        this.B.loadAlubm(this.p);
                        return;
                    }
                    b(MTD_CALL_NATIVE_PHOTO, "没有存储权限");
                }
            } else if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                while (i3 < strArr.length) {
                    if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i3])) {
                        if (i3 < iArr.length && iArr[i3] == -1) {
                            b("没有相机权限");
                            return;
                        }
                    } else if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equalsIgnoreCase(strArr[i3]) && i3 < iArr.length && iArr[i3] == -1) {
                        b("没有存储权限");
                        return;
                    }
                    i3++;
                }
                if (245 == i2) {
                    k(getActivity(), this.n, this.o, str);
                } else if (246 == i2) {
                    m(getActivity(), this.n, this.o, str);
                }
            } else {
                b("没有相机和存储权限");
            }
        }
    }

    public void postEvent(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                EventBus.getInstance().post(new EventBus.Event(eventBus, string, string2));
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, "");
                }
            } catch (Exception e2) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#postEventFail");
            }
        }
    }

    public void preOrderPay(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048605, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
            return;
        }
        PayStatisticsUtil.onEventWithValue("#preOrderPay", CheckUtils.stripUrlParams(str2));
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterPreOrderPay").data("options", str), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ILightappInvokerCallback f25370a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f25371b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LightappBusinessClient f25372c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iLightappInvokerCallback, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25372c = this;
                this.f25370a = iLightappInvokerCallback;
                this.f25371b = str2;
            }

            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                    if (i2 == 0) {
                        if (hashMap == null || hashMap.size() <= 0) {
                            return;
                        }
                        String str3 = (String) hashMap.get("result");
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        try {
                            if (((Integer) new JSONObject(str3).get("result")).intValue() == 0) {
                                this.f25370a.onResult(0, str3);
                            } else {
                                this.f25370a.onResult(1, str3);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(CheckUtils.stripUrlParams(this.f25371b));
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
                    ILightappInvokerCallback iLightappInvokerCallback2 = this.f25370a;
                    String str5 = this.f25371b;
                    String num = Integer.toString(i2);
                    if (TextUtils.isEmpty(str4)) {
                        str4 = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    LightappUtils.onError(iLightappInvokerCallback2, str5, num, str4, "#preOrderPayFail");
                }
            }
        });
    }

    public void setAlubmPhotoData(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048606, this, i2, jSONObject) == null) {
            String str = this.f25341a;
            LogUtil.d(str, "resultCode = " + i2 + " ; jsonObject = " + jSONObject.toString());
            a(MTD_CALL_NATIVE_PHOTO, i2, LightappUtils.assembleResult(i2, jSONObject));
        }
    }

    public void setH5BackCb(ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iLightappInvokerCallback) == null) {
            this.C = iLightappInvokerCallback;
        }
    }

    public void setRnAuthResult(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(1048608, this, context, str, iLightappInvokerCallback, str2) != null) {
            return;
        }
        String str3 = "";
        LogUtil.d("lightapp", "setRnAuthResult url = " + str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                int intValue = ((Integer) jSONObject.get("rnauth_result")).intValue();
                try {
                    String str4 = (String) jSONObject.get("rnauth_des");
                    try {
                        iLightappInvokerCallback.onResult(0, "");
                        LogUtil.d(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE, "setRnAuthResult OK");
                        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data("statusCode", Integer.valueOf(intValue)).data("desc", str4), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ ILightappInvokerCallback f25408a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f25409b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ LightappBusinessClient f25410c;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, iLightappInvokerCallback, str2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f25410c = this;
                                this.f25408a = iLightappInvokerCallback;
                                this.f25409b = str2;
                            }

                            @Override // com.baidu.wallet.router.RouterCallback
                            public void onResult(int i3, HashMap hashMap) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                                    if (i3 != 0) {
                                        LightappUtils.onError(this.f25408a, this.f25409b, Integer.toString(i3), "invoke_method_fail_from_router", "#setRnAuthResultFail");
                                        return;
                                    }
                                    String str5 = (String) hashMap.get("errorMsg");
                                    ILightappInvokerCallback iLightappInvokerCallback2 = this.f25408a;
                                    String str6 = this.f25409b;
                                    String num = Integer.toString(i3);
                                    if (!TextUtils.isEmpty(str5)) {
                                        str5 = LightappConstants.ROUTER_INVOKE_FAIL;
                                    }
                                    LightappUtils.onError(iLightappInvokerCallback2, str6, num, str5, "#setRnAuthResultFail");
                                }
                            }
                        });
                    } catch (JSONException e2) {
                        e = e2;
                        str3 = str4;
                        i2 = intValue;
                        e.printStackTrace();
                        LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i2), str3, "#setRnAuthResultFail");
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
            } catch (JSONException e4) {
                e = e4;
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, Integer.toString(i2), str3, "#setRnAuthResultFail");
        }
    }

    public void setRnAuthResultInMainThread(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048609, this, context, str, iLightappInvokerCallback, str2) == null) {
            Runnable runnable = new Runnable(this, context, str, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f25390a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25391b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f25392c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f25393d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f25394e;

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
                    this.f25394e = this;
                    this.f25390a = context;
                    this.f25391b = str;
                    this.f25392c = iLightappInvokerCallback;
                    this.f25393d = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f25394e.setRnAuthResult(this.f25390a, this.f25391b, this.f25392c, this.f25393d);
                    }
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    private void d(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65574, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    private void e(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65577, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, IGET, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION] complete} */
    private void f(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65579, this, context, str, iLightappInvokerCallback, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (!this.w) {
                try {
                    this.f25343e = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                    Class<?> cls = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                    this.f25345g = cls;
                    this.f25344f = this.f25343e.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, Context.class, String.class, Boolean.TYPE, cls);
                    jSONArray.put("0");
                } finally {
                    try {
                    } finally {
                    }
                }
            } else if (this.f25343e != null && this.f25345g != null && this.f25344f != null) {
                jSONArray.put("0");
            }
            if (LocalRouter.getInstance(context).isProviderExisted("livenessidentifyauth")) {
                jSONArray.put("1");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                if (!this.x) {
                    try {
                        this.f25346h = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessManager");
                        Class<?> cls2 = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessCallback");
                        this.j = cls2;
                        this.f25347i = this.f25346h.getDeclaredMethod("startDetact", Context.class, String.class, cls2);
                        jSONArray.put("2");
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } else if (this.f25346h != null && this.j != null && this.f25347i != null) {
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
    }

    private void g(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65581, this, context, str, iLightappInvokerCallback, str2) == null) {
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
    }

    private void c(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65570, this, context, str, iLightappInvokerCallback, str2) == null) {
            a aVar = new a(this);
            aVar.f25442e = iLightappInvokerCallback;
            aVar.f25444g = str2;
            this.E.obtainMessage(2, aVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, aVar) == null) {
            try {
                AudioRecorder.getInstance().end();
                aVar.f25442e.onResult(0, "{\"result\":0}");
            } catch (Exception e2) {
                LightappUtils.onError(aVar.f25442e, aVar.f25444g, LightappConstants.ERRCODE_INNER_ERROR, e2.getLocalizedMessage(), "endRecordingFail");
            }
        }
    }

    private boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65572, this, str)) == null) ? a(str, -1L) : invokeL.booleanValue;
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, str, str2) == null) {
            LogUtil.logd("method:" + str + "options=" + str2);
        }
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65562, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                if (PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("callback", null);
                    if (LightappJsClient.isJsFunNameValid(optString)) {
                        a aVar = new a(this);
                        if (!SdpPrefer.AUDIO_STEREO.equals(jSONObject.optString("channelType", "mono"))) {
                            aVar.f25439b = 16;
                        } else {
                            aVar.f25439b = 12;
                        }
                        int optInt = jSONObject.optInt("samplingAccuracy", 16);
                        aVar.f25440c = optInt;
                        if (8 != optInt) {
                            aVar.f25440c = 2;
                        } else {
                            aVar.f25440c = 3;
                        }
                        aVar.f25438a = jSONObject.optInt("samplingRate", 8000);
                        aVar.f25441d = jSONObject.optInt("maxChunkSize", 2048);
                        aVar.f25443f = optString;
                        aVar.f25442e = iLightappInvokerCallback;
                        aVar.f25444g = str2;
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
    }

    private void a(Context context, int i2, ILightappInvokerCallback iLightappInvokerCallback, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{context, Integer.valueOf(i2), iLightappInvokerCallback, str, Boolean.valueOf(z)}) == null) {
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("dxmPay").action("enterIdCardDetect").data("type", Integer.valueOf(i2)).data("showAlbum", Boolean.valueOf(z)), new AnonymousClass12(this, iLightappInvokerCallback, str, context));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, MOVE_EXCEPTION] complete} */
    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
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
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, aVar) == null) {
            try {
                if (getActivity() != null) {
                    AudioRecorder audioRecorder = AudioRecorder.getInstance();
                    if (audioRecorder.init(aVar.f25438a, aVar.f25439b, aVar.f25440c, aVar.f25441d)) {
                        aVar.f25445h = UUID.randomUUID().toString();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", 0);
                        jSONObject.put("recordId", aVar.f25445h);
                        aVar.f25442e.onResult(0, jSONObject.toString());
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("recordId", aVar.f25445h);
                        jSONObject2.put("hasNext", 1);
                        audioRecorder.addObserver(new Observer(this, audioRecorder, aVar, jSONObject2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public AudioVolume f25415a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AudioRecorder f25416b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ a f25417c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ JSONObject f25418d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ LightappBusinessClient f25419e;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, audioRecorder, aVar, jSONObject2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f25419e = this;
                                this.f25416b = audioRecorder;
                                this.f25417c = aVar;
                                this.f25418d = jSONObject2;
                                this.f25415a = new AudioVolume(4000);
                            }

                            @Override // java.util.Observer
                            public void update(Observable observable, Object obj) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, observable, obj) == null) && this.f25416b == observable && this.f25419e.getActivity() != null) {
                                    if (obj instanceof ByteBuffer) {
                                        ByteBuffer byteBuffer = (ByteBuffer) obj;
                                        this.f25415a.calAccumulatedVolume(byteBuffer, 2 == this.f25417c.f25440c);
                                        try {
                                            this.f25418d.put("volume", this.f25415a.getVolume());
                                            LogUtil.d("volume", "update: " + this.f25415a);
                                            this.f25418d.put("data", Base64.encodeToString(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining(), 2));
                                            this.f25419e.getActivity().runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;

                                                /* renamed from: a  reason: collision with root package name */
                                                public final /* synthetic */ AnonymousClass5 f25420a;

                                                {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 != null) {
                                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                                        newInitContext.initArgs = r2;
                                                        Object[] objArr = {this};
                                                        interceptable3.invokeUnInit(65536, newInitContext);
                                                        int i2 = newInitContext.flag;
                                                        if ((i2 & 1) != 0) {
                                                            int i3 = i2 & 2;
                                                            newInitContext.thisArg = this;
                                                            interceptable3.invokeInitBody(65536, newInitContext);
                                                            return;
                                                        }
                                                    }
                                                    this.f25420a = this;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                        try {
                                                            this.f25420a.f25419e.B.executeJsFunction(this.f25420a.f25417c.f25443f, this.f25420a.f25418d.toString());
                                                        } catch (Exception e2) {
                                                            LogUtil.e("audioData", "update error: ", e2);
                                                        }
                                                    }
                                                }
                                            });
                                        } catch (Exception e2) {
                                            LogUtil.e("audioData", "update: ", e2);
                                        }
                                    } else if (obj instanceof AudioRecorder.State) {
                                        if (AudioRecorder.State.STOP == ((AudioRecorder.State) obj)) {
                                            try {
                                                this.f25418d.put("hasNext", 0);
                                                this.f25418d.remove("data");
                                                this.f25418d.remove("volume");
                                                this.f25419e.getActivity().runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5.2
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;

                                                    /* renamed from: a  reason: collision with root package name */
                                                    public final /* synthetic */ AnonymousClass5 f25421a;

                                                    {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = r2;
                                                            Object[] objArr = {this};
                                                            interceptable3.invokeUnInit(65536, newInitContext);
                                                            int i2 = newInitContext.flag;
                                                            if ((i2 & 1) != 0) {
                                                                int i3 = i2 & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.f25421a = this;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                            try {
                                                                this.f25421a.f25419e.B.executeJsFunction(this.f25421a.f25417c.f25443f, this.f25421a.f25418d.toString());
                                                            } catch (Exception e3) {
                                                                LogUtil.e("audioData", "update error: ", e3);
                                                            }
                                                        }
                                                    }
                                                });
                                            } catch (Exception e3) {
                                                LogUtil.e("audioData", "update: ", e3);
                                            }
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
                LightappUtils.onError(aVar.f25442e, aVar.f25444g, LightappConstants.ERRCODE_INNER_ERROR, e2.getLocalizedMessage(), "startRecordingFail");
            }
        }
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, this, context, str, iLightappInvokerCallback, str2) == null) {
            if (!PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                BaiduWalletUtils.requestPermissionsDialog(DangerousPermissionUtils.DPU_SOURCE_LANGBRIDGE, getActivity(), new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack(this, context, str, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f25422a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f25423b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ ILightappInvokerCallback f25424c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f25425d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f25426e;

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
                        this.f25426e = this;
                        this.f25422a = context;
                        this.f25423b = str;
                        this.f25424c = iLightappInvokerCallback;
                        this.f25425d = str2;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (this.f25426e.F == null) {
                                this.f25426e.F = new HashMap();
                            }
                            this.f25426e.F.put(LightappBusinessClient.MTD_START_AUDIO_RECORD, new b(this.f25426e, this.f25422a, this.f25423b, this.f25424c, this.f25425d));
                            if (bool.booleanValue()) {
                                if (PermissionManager.checkCallingOrSelfPermission(this.f25426e.getActivity(), new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 244)) {
                                    return;
                                }
                                LightappUtils.onError(this.f25424c, this.f25425d, LightappConstants.ERRCODE_NO_PERMISSION, "无录音权限", "startRecordingFail");
                                return;
                            }
                            this.f25426e.onRequestPermissionsResult("", 244, new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, new int[]{-1});
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
            } else {
                b(context, str, iLightappInvokerCallback, str2);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, str) == null) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = str;
            a("callNativeVoice", 1, lightAppErrorModel.toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, str) == null) {
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
    }

    private void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, this, str, str2) == null) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = str2;
            a(str, 1, lightAppErrorModel.toJson());
        }
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, this, new Object[]{context, str, iLightappInvokerCallback, str2, Boolean.valueOf(z)}) == null) {
            String str3 = z ? MTD_BINDCARD_INDEPENDENT : MTD_BINDCARD_INITIATIVE;
            PayStatisticsUtil.onEventWithValue("#" + str3, CheckUtils.stripUrlParams(str2));
            doBindCard(context, str, iLightappInvokerCallback, str2, str3);
        }
    }

    private void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65564, this, context, jSONObject) == null) || context == null || jSONObject == null) {
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
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, context.getPackageName(), null));
                context.startActivity(intent);
            } catch (Exception unused) {
                context.startActivity(new Intent("android.settings.SETTINGS"));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, this, str, i2, str2) == null) {
            try {
                if (this.z == null || (iLightappInvokerCallback = this.z.get(str)) == null) {
                    return;
                }
                iLightappInvokerCallback.onResult(i2, str2);
                this.z.remove(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2, boolean z) {
        byte[] rsaDecrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{context, str, iLightappInvokerCallback, str2, Boolean.valueOf(z)}) == null) {
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
                                        if (Coder.KEY_DES.equals(optString3)) {
                                            rsaDecrypt = Crypto.desEncrypt(decode, optString);
                                        } else if ("AES".equals(optString3)) {
                                            rsaDecrypt = Crypto.aesEncrypt(decode, optString);
                                        } else if ("RSA".equals(optString3)) {
                                            rsaDecrypt = Crypto.rsaEncrypt(decode, optString);
                                        } else {
                                            throw new NoSuchAlgorithmException(optString3);
                                        }
                                    } else if (Coder.KEY_DES.equals(optString3)) {
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
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, localizedMessage, "#" + str3 + ActLog.TYPE_FAIL);
            }
        }
    }

    private String a(Context context, JSONObject jSONObject) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, context, jSONObject)) == null) {
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
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, context, str)) == null) {
            return PhoneUtils.getApplicationName(context) + "没有" + str;
        }
        return (String) invokeLL.objValue;
    }

    private boolean a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65558, this, str, j)) == null) {
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
        return invokeLJ.booleanValue;
    }
}
