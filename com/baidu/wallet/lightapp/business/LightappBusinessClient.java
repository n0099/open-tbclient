package com.baidu.wallet.lightapp.business;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
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
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.Crypto;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.EncodeUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.fsg.base.statistics.h;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.rtc.SdpPrefer;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.audio.AudioRecorder;
import com.baidu.wallet.base.audio.AudioVolume;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
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
import com.baidu.wallet.livenessidentifyauth.DXMBioRecogSDK;
import com.baidu.wallet.livenessidentifyauth.api.DXMFaceLivenessCallback;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.ImageBase64Utils;
import com.baidu.wallet.utils.NetUtils;
import com.baidu.wallet.utils.StringUtil;
import com.baidu.webkit.sdk.PermissionRequest;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.kuaishou.weapon.un.s;
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
import java.util.Collection;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes13.dex */
public class LightappBusinessClient implements ILightappInvoker, com.baidu.wallet.lightapp.business.presenter.b {
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
    public static final String MTD_GET_PERMISSIOM_DIALOG_MSG = "getPermissionDialogDescription";
    public static final String MTD_GET_PERMISSION_STATE = "getPermissionState";
    public static final String MTD_GET_SUPPORT_LIST = "getSupportedMethodList";
    public static final String MTD_GOTO_DXM_PAY_SERVICE = "gotoDXMPayService";
    public static final String MTD_GO_TO_APP_SETTING = "goToAppSetting";
    public static final String MTD_H5GOBCK = "onBDWalletPageGoBack";
    public static final String MTD_LIST_MY_BANK_CARD = "listMyBankCard";
    public static final String MTD_OPEN_IN_BROWSER = "openInBrowser";
    public static final String MTD_OPEN_NEW_LIGHT_BRIDGE = "openInNewLightBridge";
    public static final String MTD_PRECASHIER_GET_DEFAULT_PAY_METHOD = "getPayMethod";
    public static final String MTD_PRECASHIER_MODIFY_PAY_METHOD = "changePayMethod";
    public static final String MTD_PRECASHIER_ORDER_PAY_METHOD = "preOrderPay";
    public static final String MTD_SELECT_PHONE_FROM_ADRESSBOOK = "selectPhonefromAdressBook";
    public static final String MTD_SEND_TO_SMS = "sendToSMS";
    public static final String MTD_SETMENU = "setMenu";
    public static final String MTD_SETSUBMENU = "setSubMenu";
    public static final String MTD_SETTITLE = "setTitle";
    public static final String MTD_SET_FULLSCREEN = "setFullScreen";
    public static final String MTD_START_AUDIO_RECORD = "startRecording";
    public static final String MTD_STATEVENT = "doEvent";
    public static final String MTD_UNREGISTER_H5_GO_BACK = "unregisterOnBDWalletPageGoBack";
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
    public static int f53540b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f53541c = 1;
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
    public String a;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53542d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?> f53543e;

    /* renamed from: f  reason: collision with root package name */
    public Method f53544f;

    /* renamed from: g  reason: collision with root package name */
    public Class<?> f53545g;

    /* renamed from: h  reason: collision with root package name */
    public Class<?> f53546h;

    /* renamed from: i  reason: collision with root package name */
    public Method f53547i;

    /* renamed from: j  reason: collision with root package name */
    public Class<?> f53548j;

    /* renamed from: k  reason: collision with root package name */
    public Class<?> f53549k;
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
    /* loaded from: classes13.dex */
    public class AnonymousClass12 implements RouterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ILightappInvokerCallback a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f53553c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LightappBusinessClient f53554d;

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
            this.f53554d = lightappBusinessClient;
            this.a = iLightappInvokerCallback;
            this.f53552b = str;
            this.f53553c = context;
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
                        public final /* synthetic */ LightAppCallIDPhotoModel a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f53555b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f53556c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ ImageBase64Utils f53557d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass12 f53558e;

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
                            this.f53558e = this;
                            this.a = lightAppCallIDPhotoModel;
                            this.f53555b = string;
                            this.f53556c = string2;
                            this.f53557d = imageBase64Utils;
                        }

                        @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                        public void onBase64Result(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                this.a.cnt.front = str;
                                this.f53557d.getImageBase64(this.f53556c, 640, new ImageBase64Utils.ImageBase64Listener(this) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.12.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 a;

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
                                        this.a = this;
                                    }

                                    @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                                    public void onBase64Result(String str2) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                            AnonymousClass1 anonymousClass1 = this.a;
                                            LightAppCallIDPhotoModel lightAppCallIDPhotoModel2 = anonymousClass1.a;
                                            lightAppCallIDPhotoModel2.cnt.back = str2;
                                            anonymousClass1.f53558e.a.onResult(0, lightAppCallIDPhotoModel2.toJson());
                                            try {
                                                if (this.a.f53555b != null) {
                                                    File file = new File(this.a.f53555b);
                                                    if (file.exists()) {
                                                        file.delete();
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                            try {
                                                if (this.a.f53556c != null) {
                                                    File file2 = new File(this.a.f53556c);
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
                    int intValue = ((Integer) hashMap.get("errCode")).intValue();
                    String str = (String) hashMap.get("errMsg");
                    if (intValue == -1) {
                        LightappUtils.onError(this.a, this.f53552b, LightappConstants.ERRCODE_NO_PERMISSION, this.f53554d.a(this.f53553c, "访问相机的权限"), "#callIDPotosFail");
                    } else if (-2 == intValue) {
                        LightappUtils.onError(this.a, this.f53552b, LightappConstants.ERRCODE_CANCEL, "取消", "#callIDPotosFail");
                    }
                } else {
                    String str2 = (String) hashMap.get("errorMsg");
                    ILightappInvokerCallback iLightappInvokerCallback = this.a;
                    String str3 = this.f53552b;
                    String num = Integer.toString(i2);
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = LightappConstants.ROUTER_INVOKE_FAIL;
                    }
                    LightappUtils.onError(iLightappInvokerCallback, str3, num, str2, "#callIDPotosFail");
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f53624b;

        /* renamed from: c  reason: collision with root package name */
        public int f53625c;

        /* renamed from: d  reason: collision with root package name */
        public int f53626d;

        /* renamed from: e  reason: collision with root package name */
        public ILightappInvokerCallback f53627e;

        /* renamed from: f  reason: collision with root package name */
        public String f53628f;

        /* renamed from: g  reason: collision with root package name */
        public String f53629g;

        /* renamed from: h  reason: collision with root package name */
        public String f53630h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ LightappBusinessClient f53631i;

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
            this.f53631i = lightappBusinessClient;
        }
    }

    /* loaded from: classes13.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public String f53632b;

        /* renamed from: c  reason: collision with root package name */
        public ILightappInvokerCallback f53633c;

        /* renamed from: d  reason: collision with root package name */
        public String f53634d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LightappBusinessClient f53635e;

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
            this.f53635e = lightappBusinessClient;
            this.a = context;
            this.f53632b = str;
            this.f53633c = iLightappInvokerCallback;
            this.f53634d = str2;
        }
    }

    /* loaded from: classes13.dex */
    public static class c implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ILightappInvokerCallback a;

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
            this.a = iLightappInvokerCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                if (this.a != null) {
                    if ("onResult".equals(method.getName())) {
                        if (objArr != null && objArr.length >= 2) {
                            this.a.onResult(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                        }
                        return null;
                    }
                    return method.invoke(this.a, objArr);
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
        this.a = LightappBusinessClient.class.getSimpleName();
        this.f53542d = false;
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
            public final /* synthetic */ LightappBusinessClient a;

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
                this.a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (1 == i4) {
                        this.a.a((a) message.obj);
                    } else if (2 == i4) {
                        this.a.b((a) message.obj);
                    }
                }
            }
        };
    }

    private void A(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                String permissionDialogDescription = DangerousPermissionUtils.getInstance().getPermissionDialogDescription(context, new JSONObject(str).optString("type"));
                if (TextUtils.isEmpty(permissionDialogDescription)) {
                    LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "type invalidate", "#getPermissionDialogDescriptionFail");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("content", permissionDialogDescription);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject));
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "params invalidate", "#getPermissionDialogDescriptionFail");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:3|(2:4|5)|(6:10|11|12|13|14|(2:16|17)(1:19))|24|11|12|13|14|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
        r6.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void B(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLLL(65539, this, context, str, iLightappInvokerCallback, str2) != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contacts", PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS"));
            jSONObject.put("location", PermissionManager.checkCallingPermission(context, s.f57423g));
            jSONObject.put("camera", PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
            jSONObject.put(MediaStreamTrack.AUDIO_TRACK_KIND, PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!PermissionManager.checkCallingPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") && !PermissionManager.checkCallingPermission(context, s.f57425i)) {
            z = false;
            jSONObject.put("storage", z);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errCode", 0);
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
        jSONObject22.put("errCode", 0);
        jSONObject22.put("des", "成功");
        jSONObject22.put("permissions", jSONObject);
        if (iLightappInvokerCallback == null) {
        }
    }

    private void C(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, iLightappInvokerCallback, str2) == null) {
            LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "uploadMsg, options: " + str);
            if (!TextUtils.isEmpty(str)) {
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
                            linkedHashMap.put("referer", jSONObject.optString("referer"));
                            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(optString3).toString());
                            Tracker.sendPerformanceInfoToSensors(optString, linkedHashMap, context);
                        } else if (optString.equals("window_exception") || optString.equals("cross_origin_exception")) {
                            linkedHashMap.put("url", optString3);
                            linkedHashMap.put("message", jSONObject.optString("message"));
                            linkedHashMap.put("referer", jSONObject.optString("referer"));
                            linkedHashMap.put("uuid", jSONObject.optString("uuid"));
                            linkedHashMap.put("stack", jSONObject.optString("stack"));
                            linkedHashMap.put(BreakpointSQLiteKey.FILENAME, jSONObject.optString(BreakpointSQLiteKey.FILENAME));
                            linkedHashMap.put("pkgInfo", LangbridgeCacheManager.getInstance().getSummaryOfflineCacheInfo(optString3).toString());
                            try {
                                this.B.checkClodDown((String) linkedHashMap.get("message"), Arrays.asList(optString3), optString);
                                Tracker.send(optString, linkedHashMap, context, optString2);
                            } catch (JSONException e2) {
                                e = e2;
                                e.printStackTrace();
                                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e.getLocalizedMessage(), "#uploadMsgFail");
                            }
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
            }
        }
    }

    private void D(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65541, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
            return;
        }
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPayService").action("enterDxmPayService").data("options", str), new RouterCallback(this, iLightappInvokerCallback) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ILightappInvokerCallback a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LightappBusinessClient f53580b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iLightappInvokerCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53580b = this;
                this.a = iLightappInvokerCallback;
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
                                this.a.onResult(0, str3);
                            } else {
                                this.a.onResult(1, str3);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            this.a.onResult(1, "JsonException");
                        }
                    } else if (hashMap == null || hashMap.size() <= 0) {
                    } else {
                        this.a.onResult(1, (String) hashMap.get("result"));
                    }
                }
            }
        });
    }

    private void E(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65542, this, context, str, iLightappInvokerCallback, str2) == null) || this.B == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("icon_url");
            String optString2 = jSONObject.optString("callback");
            String optString3 = jSONObject.optString("bubble_text");
            int i2 = jSONObject.optInt("visibility", 1) == 0 ? 4 : 0;
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                this.B.setSubMenu(optString, optString2, optString3, i2);
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult((Map<String, Object>) new HashMap(), true));
                }
            } else {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数异常", "#setSubMenuFail");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#setSubMenuFail");
        }
    }

    private long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, this, j2)) == null) {
            if (SVC_ID_H5_HOMEPAGE == j2) {
                return 16384L;
            }
            if (SVC_ID_H5_BALANCE == j2) {
                return 32L;
            }
            if (SVC_ID_H5_TRANSERECORD == j2) {
                return 16L;
            }
            if (SVC_ID_H5_COUPON == j2) {
                return 64L;
            }
            if (SVC_ID_H5_MYBANKCARD == j2) {
                return 4L;
            }
            if (SVC_ID_H5_SECURITCENTER == j2) {
                return 8L;
            }
            if (SVC_ID_H5_CASHBACK == j2) {
                return 8192L;
            }
            if (SVC_ID_H5_CHARGE == j2) {
                return 1L;
            }
            if (SVC_ID_H5_TRANSFER == j2) {
                return 2L;
            }
            if (SVC_ID_H5_SCANQR == j2) {
                return 32768L;
            }
            if (SVC_ID_H5_QRGEN == j2) {
                return 512L;
            }
            if (10013 == j2) {
                return WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_CHECK;
            }
            if (SVC_ID_H5_PAY_SET == j2) {
                return WalletServiceBeanConst.SERVICE_ID_WALLET_PAY_SET;
            }
            if (SVC_ID_H5_PWD_SET == j2) {
                return WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_SET;
            }
            return -1L;
        }
        return invokeJ.longValue;
    }

    private void e(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65582, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                String optString = new JSONObject(str).optString("data", null);
                if (!TextUtils.isEmpty(optString)) {
                    if (!((JSONObject) new JSONTokener(optString).nextValue()).has(h.a)) {
                        throw new InvalidParameterException("invalid parameter [data->en] (null)");
                    }
                    if (iLightappInvokerCallback != null) {
                        iLightappInvokerCallback.onResult(0, "{\"result\":0}");
                        return;
                    }
                    return;
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
        if (interceptable == null || interceptable.invokeLLLL(65583, this, context, str, iLightappInvokerCallback, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (a(str2)) {
                jSONArray.put("0");
            }
            if (BeanConstants.CHANNEL_ID.equals("iqiyi")) {
                jSONArray.put("1");
            } else if (LocalRouter.getInstance(context).isProviderExisted("livenessidentifyauth")) {
                jSONArray.put("1");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                if (!this.x) {
                    try {
                        this.f53546h = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessManager");
                        Class<?> cls = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessCallback");
                        this.f53548j = cls;
                        this.f53547i = this.f53546h.getDeclaredMethod("startDetact", Context.class, String.class, cls);
                        jSONArray.put("2");
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } else if (this.f53546h != null && this.f53548j != null && this.f53547i != null) {
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
        if (interceptable == null || interceptable.invokeLLLL(65584, this, context, str, iLightappInvokerCallback, str2) == null) {
            this.n = str;
            this.o = iLightappInvokerCallback;
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
                    LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, EnterDxmPayServiceAction.ERR_MSG, "#callNativeVoice");
                } else {
                    l(context, str, iLightappInvokerCallback, str2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    private void h(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65585, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                HashMap hashMap = (HashMap) JsonUtils.fromJson(new JSONObject(str).getString("dxmPayLiveness"), HashMap.class);
                if (BeanConstants.CHANNEL_ID.equals("iqiyi")) {
                    b(context, hashMap, iLightappInvokerCallback, str2);
                } else {
                    a(context, hashMap, iLightappInvokerCallback, str2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, EnterDxmPayServiceAction.ERR_MSG, "#identifyAuthFail");
            }
        }
    }

    private void i(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65586, this, context, str, iLightappInvokerCallback, str2) == null) {
            Set<String> methodList = LightAppWrapper.getInstance().getMethodList();
            if (methodList != null && methodList.contains("callNativeVoice")) {
                LightAppWrapper.getInstance().lightappInvoke(context, str, iLightappInvokerCallback);
            } else if (!a(str2)) {
                LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
                LightAppErrorModel.Data data = lightAppErrorModel.cnt;
                data.errCode = "10004";
                data.des = "没有找到对应的方法";
                iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
            } else {
                WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(context, new ILoginBackListener(this, iLightappInvokerCallback, str2, str, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ILightappInvokerCallback a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f53620b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f53621c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Context f53622d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f53623e;

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
                        this.f53623e = this;
                        this.a = iLightappInvokerCallback;
                        this.f53620b = str2;
                        this.f53621c = str;
                        this.f53622d = context;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                            LightappUtils.onError(this.a, this.f53620b, String.valueOf(101), "请重新登录!", "#callNativeVoiceFail");
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                            try {
                                Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f53623e.f53545g}, new c(this.a));
                                boolean equals = "ONLINE".equals(DebugConfig.getInstance().getEnvironment());
                                JSONObject jSONObject = new JSONObject(this.f53621c);
                                jSONObject.put("stoken", WalletLoginHelper.getInstance().getLoginStoken());
                                this.f53623e.f53544f.invoke(null, this.f53622d, jSONObject.toString(), Boolean.valueOf(equals), newProxyInstance);
                            } catch (Throwable unused) {
                                LightappUtils.onError(this.a, this.f53620b, LightappConstants.ERRCODE_INNER_ERROR, "reflect callNativeVoice fail!", "#callNativeVoiceFail");
                            }
                        }
                    }
                }));
            }
        }
    }

    private void j(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65587, this, context, str, iLightappInvokerCallback, str2) == null) || CheckUtils.isFastDoubleClick()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = "10004";
            data.des = "系统版本不支持";
            iLightappInvokerCallback.onResult(1, lightAppErrorModel.toJson());
        } else if (PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) && PermissionManager.checkCallingPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            k(context, str, iLightappInvokerCallback, str2);
        } else {
            BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53550b;

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
                    this.f53550b = this;
                    this.a = str2;
                }

                @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                public void isAllAgree(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        if (bool.booleanValue()) {
                            PermissionManager.checkCallingOrSelfPermission(this.f53550b.B.getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"}, 245);
                        } else {
                            this.f53550b.onRequestPermissionsResult(this.a, 245, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"}, new int[]{-1, -1});
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, CONST_STR, INVOKE, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, IPUT, MOVE_EXCEPTION] complete} */
    private void k(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65588, this, context, str, iLightappInvokerCallback, str2) == null) {
            if (!this.x) {
                try {
                    this.f53546h = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessManager");
                    Class<?> cls = Class.forName("com.duxiaoman.wallet.facelivenesslib.DXMFaceLivenessCallback");
                    this.f53548j = cls;
                    this.f53547i = this.f53546h.getDeclaredMethod("startDetact", Context.class, String.class, cls);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            if (this.f53546h != null && this.f53548j != null && this.f53547i != null) {
                try {
                    this.f53547i.invoke(null, context, str, Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f53548j}, new c(iLightappInvokerCallback)));
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
        if (interceptable == null || interceptable.invokeLLLL(65589, this, context, str, iLightappInvokerCallback, str2) == null) {
            if (PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) && PermissionManager.checkCallingPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                m(context, str, iLightappInvokerCallback, str2);
            } else {
                PermissionManager.checkCallingOrSelfPermission(getActivity(), new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"}, 246);
            }
        }
    }

    private void m(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65590, this, context, str, iLightappInvokerCallback, str2) == null) {
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
        if (!(interceptable == null || interceptable.invokeLLLL(65591, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
            return;
        }
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
        if (interceptable == null || interceptable.invokeLLLL(65592, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                        throw new InvalidParameterException(EnterDxmPayServiceAction.ERR_MSG);
                    }
                    if (PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
                        if (this.B != null) {
                            this.B.selectPhoneFromAddressBook();
                            return;
                        }
                        return;
                    }
                    BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", getActivity(), new String[]{"android.permission.READ_CONTACTS"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LightappBusinessClient f53551b;

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
                            this.f53551b = this;
                            this.a = str2;
                        }

                        @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                        public void isAllAgree(Boolean bool) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                                if (bool.booleanValue()) {
                                    if (PermissionManager.checkCallingOrSelfPermission(this.f53551b.getActivity(), new String[]{"android.permission.READ_CONTACTS"}, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK)) {
                                        return;
                                    }
                                    this.f53551b.b(this.a);
                                    return;
                                }
                                this.f53551b.onRequestPermissionsResult("", LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, new String[]{"android.permission.READ_CONTACTS"}, new int[]{-1});
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
        if (!(interceptable == null || interceptable.invokeLLLL(65593, this, context, str, iLightappInvokerCallback, str2) == null) || this.B == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65594, this, context, str, iLightappInvokerCallback, str2) == null) || this.B == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65595, this, context, str, iLightappInvokerCallback, str2) == null) {
        }
    }

    private void s(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65596, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    if (iLightappInvokerCallback != null) {
                        LogUtil.i(this.a, "Open in Browser fail");
                        iLightappInvokerCallback.onResult(1, "url为空");
                        return;
                    }
                    return;
                }
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                LogUtil.i(this.a, "Open in Browser Success");
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(0, "");
                }
            } catch (Exception e2) {
                LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, e2.getLocalizedMessage(), "#openInBrowserFail");
            }
        }
    }

    private void t(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65597, this, context, str, iLightappInvokerCallback, str2) == null) || this.B == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65598, this, context, str, iLightappInvokerCallback, str2) == null) {
            DXMSdkSAUtils.onEventWithValues("#onBDWalletPageGoBack", Arrays.asList(CheckUtils.stripUrlParams(str2)));
            setH5BackCb(iLightappInvokerCallback);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        int i2;
        JSONObject jSONObject;
        LightappBusinessClient lightappBusinessClient;
        Context context2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65599, this, context, str, iLightappInvokerCallback, str2) == null) || iLightappInvokerCallback == null) {
            return;
        }
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
                jSONObject2.put("errCode", 1);
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
        }
        if (z) {
            str3 = LightappUtils.assembleResult(1, jSONObject2);
        }
        iLightappInvokerCallback.onResult(i2, str3);
    }

    private void w(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65600, this, context, str, iLightappInvokerCallback, str2) == null) {
            String str3 = this.a;
            LogUtil.d(str3, "callNativePhoto options = " + str);
            if (str != null && str.contains("multipleMaxCount")) {
                y(context, str, iLightappInvokerCallback, str2);
            } else {
                x(context, str, iLightappInvokerCallback, str2);
            }
        }
    }

    private void x(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65601, this, context, str, iLightappInvokerCallback, str2) == null) {
            this.p = str;
            if (!PermissionManager.checkCallingPermission(this.B.getContext(), s.f57425i)) {
                BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", this.B.getActivity(), new String[]{s.f57425i}, new BaiduWalletUtils.IRequestPermissionCallBack(this, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f53565b;

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
                        this.f53565b = this;
                        this.a = str2;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                PermissionManager.checkCallingOrSelfPermission(this.f53565b.B.getActivity(), new String[]{s.f57425i}, 4);
                            } else {
                                this.f53565b.onRequestPermissionsResult(this.a, 4, new String[]{s.f57425i}, new int[]{-1});
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

    private void y(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65602, this, context, str, iLightappInvokerCallback, str2) == null) {
            this.p = str;
            if (!PermissionManager.checkCallingPermission(this.B.getContext(), s.f57425i)) {
                BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", this.B.getActivity(), new String[]{s.f57425i}, new BaiduWalletUtils.IRequestPermissionCallBack(this, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f53566b;

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
                        this.f53566b = this;
                        this.a = str2;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                PermissionManager.checkCallingOrSelfPermission(this.f53566b.B.getActivity(), new String[]{s.f57425i}, 4);
                            } else {
                                this.f53566b.onRequestPermissionsResult(this.a, 4, new String[]{s.f57425i}, new int[]{-1});
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
                a(context, str, str2);
            }
        }
    }

    private void z(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65603, this, context, str, iLightappInvokerCallback, str2) == null) || TextUtils.isEmpty(str)) {
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
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INTENT_NOT_AVAILABLE, "intent invalid", "#sendToSMSFail");
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate options", "#sendToSMSFail");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003d A[Catch: Exception -> 0x008b, TRY_ENTER, TryCatch #1 {Exception -> 0x008b, blocks: (B:22:0x002b, B:25:0x003d, B:27:0x0041, B:29:0x004b, B:34:0x0057, B:37:0x0070, B:39:0x0074), top: B:49:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041 A[Catch: Exception -> 0x008b, TryCatch #1 {Exception -> 0x008b, blocks: (B:22:0x002b, B:25:0x003d, B:27:0x0041, B:29:0x004b, B:34:0x0057, B:37:0x0070, B:39:0x0074), top: B:49:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void accessWalletService(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        String str3;
        String str4;
        long parseLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    str3 = jSONObject.getString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str3 = "";
                }
                try {
                    str4 = jSONObject.getString("serviceExtra");
                } catch (Exception e3) {
                    try {
                        e3.printStackTrace();
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        str4 = "";
                        parseLong = Long.parseLong(str3);
                        if (!a(METHOD_ACCESS_WALLET_SERVICE, parseLong, str)) {
                        }
                    }
                    str4 = "";
                    parseLong = Long.parseLong(str3);
                    if (!a(METHOD_ACCESS_WALLET_SERVICE, parseLong, str)) {
                    }
                }
            } catch (Exception e5) {
                e = e5;
                str3 = "";
            }
            try {
                parseLong = Long.parseLong(str3);
                if (!a(METHOD_ACCESS_WALLET_SERVICE, parseLong, str)) {
                    LightappUtils.onError(iLightappInvokerCallback, str2, "10004", "没有找到对应的方法", "accessWalletServiceFail");
                    return;
                }
                long a2 = a(parseLong);
                if (-1 == a2) {
                    LightappUtils.onError(iLightappInvokerCallback, str2, "10004", "没有找到对应的方法", "accessWalletServiceFail");
                    return;
                }
                if (iLightappInvokerCallback != null) {
                    if (32 == a2) {
                        EventBus eventBus = EventBus.getInstance();
                        eventBus.getClass();
                        eventBus.postStickyEvent(new EventBus.Event(eventBus, H5BanlanceCallback, iLightappInvokerCallback));
                    } else if (WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_CHECK == a2) {
                        D(context, str, iLightappInvokerCallback, str2);
                        return;
                    }
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
            try {
                str3 = new JSONObject(str).optString("extra_param");
            } catch (JSONException unused) {
                str3 = "";
            }
            WalletLoginHelper.getInstance().onlyLogin(new LoginBackListenerProxy(context, new ILoginBackListener(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.27
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ILightappInvokerCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53597b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53598c;

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
                    this.f53598c = this;
                    this.a = iLightappInvokerCallback;
                    this.f53597b = str2;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str4) == null) {
                        LightappUtils.onError(this.a, this.f53597b, Integer.toString(i2), str4, "#bdLoginFail");
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str4) == null) {
                        this.a.onResult(0, "0");
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
            if (1 == parseJsonInt) {
                try {
                    i2 = (int) (new JSONObject(str).optDouble("quality") * 100.0d);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i2 = -1;
                }
                LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("idcarddetect").action("enterIdCardDetect").data("type", 6).data("showAlbum", Boolean.FALSE), new RouterCallback(this, iLightappInvokerCallback, (i2 <= 0 || 100 < i2) ? -1 : i2, str2, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.22
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ILightappInvokerCallback a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f53581b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f53582c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ Context f53583d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f53584e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iLightappInvokerCallback, Integer.valueOf(r8), str2, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f53584e = this;
                        this.a = iLightappInvokerCallback;
                        this.f53581b = r8;
                        this.f53582c = str2;
                        this.f53583d = context;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i3, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                            if (i3 == 0) {
                                if (hashMap == null || hashMap.size() <= 0) {
                                    return;
                                }
                                Bundle bundle = (Bundle) hashMap.get("result");
                                if (bundle != null) {
                                    bundle.getInt(ShaderParams.VALUE_TYPE_STEP);
                                    String string = bundle.getString("pic1");
                                    ImageBase64Utils.ImageBase64Listener imageBase64Listener = new ImageBase64Utils.ImageBase64Listener(this, new LightAppTakePictureModel(0)) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.22.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ LightAppTakePictureModel a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass22 f53585b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, r7};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f53585b = this;
                                            this.a = r7;
                                        }

                                        @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                                        public void onBase64Result(String str3) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, str3) == null) {
                                                LightAppTakePictureModel lightAppTakePictureModel = this.a;
                                                lightAppTakePictureModel.cnt.image = str3;
                                                this.f53585b.a.onResult(0, lightAppTakePictureModel.toJson());
                                            }
                                        }
                                    };
                                    ImageBase64Utils imageBase64Utils = ImageBase64Utils.getInstance();
                                    int i4 = this.f53581b;
                                    if (i4 > 0) {
                                        imageBase64Utils.getImageBase64(string, -1, i4, imageBase64Listener);
                                        return;
                                    } else {
                                        imageBase64Utils.getImageBase64(string, 640, imageBase64Listener);
                                        return;
                                    }
                                }
                                ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                                if (iLightappInvokerCallback2 != null) {
                                    iLightappInvokerCallback2.onResult(1, "internal error");
                                }
                            } else if (i3 == 1) {
                                if (hashMap == null || hashMap.size() <= 0) {
                                    return;
                                }
                                int intValue = ((Integer) hashMap.get("errCode")).intValue();
                                String str3 = (String) hashMap.get("errMsg");
                                if (intValue == -1) {
                                    LightappUtils.onError(this.a, this.f53582c, LightappConstants.ERRCODE_NO_PERMISSION, this.f53584e.a(this.f53583d, "访问相机的权限"), "#callCameraFail");
                                } else if (-2 == intValue) {
                                    LightappUtils.onError(this.a, this.f53582c, LightappConstants.ERRCODE_CANCEL, "取消", "#callCameraFail");
                                }
                            } else {
                                String str4 = (String) hashMap.get("errorMsg");
                                ILightappInvokerCallback iLightappInvokerCallback3 = this.a;
                                String str5 = this.f53582c;
                                String num = Integer.toString(i3);
                                if (!TextUtils.isEmpty(str4)) {
                                    str4 = LightappConstants.ROUTER_INVOKE_FAIL;
                                }
                                LightappUtils.onError(iLightappInvokerCallback3, str5, num, str4, "#callCameraFail");
                            }
                        }
                    }
                });
                return;
            }
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + parseJsonInt, "#callCameraFail");
        }
    }

    public void callIDPotos(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, iLightappInvokerCallback, str2) == null) {
            a(METHOD_CALL_ID_PHOTOS, str);
            if (CheckUtils.isFastDoubleClick()) {
                return;
            }
            int parseJsonInt = LightappUtils.parseJsonInt(str, "type");
            int i2 = 1 == parseJsonInt ? 1 : 2 == parseJsonInt ? 3 : 3 == parseJsonInt ? 4 : 4 == parseJsonInt ? 5 : 5 == parseJsonInt ? 6 : -1;
            if (i2 > 0) {
                a(context, i2, iLightappInvokerCallback, str2, LightappUtils.parseJsonInt(str, "showalbum") == 1);
                return;
            }
            LightappUtils.onError(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INVALID_PARAMETER, "参数非法 type:" + i2, "#callIDPotosFail");
        }
    }

    public void callQRCodeScanner(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, iLightappInvokerCallback, str2) == null) {
            int parseJsonInt = LightappUtils.parseJsonInt(str, "needScanResult");
            int parseJsonInt2 = LightappUtils.parseJsonInt(str, "type");
            int parseJsonInt3 = LightappUtils.parseJsonInt(str, "showQrCodeBtns");
            LogUtil.i("zxing", "qrCodeNeedResult" + parseJsonInt + "type" + parseJsonInt2 + "showQrCodeBtns" + parseJsonInt3);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("saoyisao").action("qrcodescanner").data("withAnim", Boolean.toString(true)).data("showQrCodeBtns", Boolean.valueOf(parseJsonInt3 == 1)).data("qrcodeNeedResult", Boolean.valueOf(parseJsonInt == f53541c)).data("type", Integer.valueOf(parseJsonInt2)), new RouterCallback(this, iLightappInvokerCallback, str2, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ILightappInvokerCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53603b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f53604c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53605d;

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
                    this.f53605d = this;
                    this.a = iLightappInvokerCallback;
                    this.f53603b = str2;
                    this.f53604c = context;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0 && hashMap != null) {
                            LogUtil.i("zxing", "onResult");
                            String str3 = (String) hashMap.get("value");
                            LightAppCallQRCodeScannerModel lightAppCallQRCodeScannerModel = new LightAppCallQRCodeScannerModel();
                            lightAppCallQRCodeScannerModel.result = 0;
                            if (!TextUtils.isEmpty(str3)) {
                                lightAppCallQRCodeScannerModel.cnt.scanResult = Base64.encodeToString(str3.getBytes(), 2);
                            }
                            LogUtil.i("zxing", "onResult:" + str3);
                            this.a.onResult(0, lightAppCallQRCodeScannerModel.toJson());
                        } else if (i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "saoyisao");
                            hashMap2.put("action", "qrcodescanresult");
                            if (hashMap != null && hashMap.size() > 0 && "notSupport".equals(hashMap.get("errorMsg"))) {
                                hashMap2.put("errmsg", hashMap.get("errorMsg"));
                            }
                            LightappUtils.onError(this.a, this.f53603b, "10004", "没有找到对应的方法", "");
                            LogUtil.d("zxing", "callQRCodeScanner check not support");
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        } else if (i2 != 1 || hashMap == null) {
                        } else {
                            int intValue = ((Integer) hashMap.get("errCode")).intValue();
                            String str4 = (String) hashMap.get("errorMsg");
                            if (intValue == 2 && TextUtils.equals(str4, "camera_permission_denied")) {
                                LightappUtils.onError(this.a, this.f53603b, LightappConstants.ERRCODE_NO_PERMISSION, this.f53605d.a(this.f53604c, "访问相机的权限"), "#callQRCodeScannerFail");
                            } else if (intValue == 0) {
                                LightappUtils.onError(this.a, this.f53603b, LightappConstants.ERRCODE_CANCEL, "取消", "#callQRCodeScannerFail");
                            }
                        }
                    }
                }
            });
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
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterChangePayMethod").data("options", str), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ILightappInvokerCallback a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f53561b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LightappBusinessClient f53562c;

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
                this.f53562c = this;
                this.a = iLightappInvokerCallback;
                this.f53561b = str2;
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
                                this.a.onResult(0, str3);
                            } else {
                                this.a.onResult(1, str3);
                            }
                            return;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    String str4 = (String) hashMap.get("errorMsg");
                    ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                    String str5 = this.f53561b;
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
            String str2 = c2 != 0 ? c2 != 1 ? c2 != 2 ? "" : "android.permission.READ_CONTACTS" : s.f57423g : PermissionRequest.RESOURCE_VIDEO_CAPTURE;
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
            a("detectBankCard", str);
            if (LocalRouter.getInstance(context).isProviderExisted("bankdetection")) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback(this, iLightappInvokerCallback, str2, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.24
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ILightappInvokerCallback a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f53589b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Context f53590c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f53591d;

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
                        this.f53591d = this;
                        this.a = iLightappInvokerCallback;
                        this.f53589b = str2;
                        this.f53590c = context;
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
                                this.a.onResult(0, lightAppDetectBankcardModel.toJson());
                            } else if (i2 != 1 || hashMap == null) {
                                if (i2 == 5) {
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("provider", "bankdetection");
                                    hashMap2.put("action", "bankcarddetction");
                                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                                }
                            } else if (((Integer) hashMap.get("errCode")).intValue() == -1) {
                                ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                                String str4 = this.f53589b;
                                LightappUtils.onError(iLightappInvokerCallback2, str4, LightappConstants.ERRCODE_NO_PERMISSION, PhoneUtils.getApplicationName(this.f53590c) + "没有访问相机的权限", "#detectBankCardFail");
                            } else if (((Integer) hashMap.get("errCode")).intValue() == -2) {
                                LightappUtils.onError(this.a, this.f53589b, LightappConstants.ERRCODE_CANCEL, "取消", "#detectBankCardFail");
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
                if (LocalRouter.getInstance(context).isProviderExisted("livenessdetect")) {
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("livenessdetect").action("livenessdetect").data(hashMap), new RouterCallback(this, iLightappInvokerCallback, str2, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.23
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ILightappInvokerCallback a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f53586b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Context f53587c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ LightappBusinessClient f53588d;

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
                            this.f53588d = this;
                            this.a = iLightappInvokerCallback;
                            this.f53586b = str2;
                            this.f53587c = context;
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
                                                this.a.onResult(0, lightAppCommonModel.toJson());
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                } else if (i2 == 5) {
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("provider", "livenessdetect");
                                    hashMap3.put("action", "livenessdetect");
                                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap3.values());
                                } else {
                                    LightappUtils.onError(this.a, this.f53586b, i2 + "", PhoneUtils.getApplicationName(this.f53587c) + ((String) hashMap2.get("errorMsg")), "#faceRegisterFail");
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
            this.f53542d = false;
            String str4 = "";
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
                        this.f53542d = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterDoInnerBind").data("showDialog", Boolean.valueOf(this.f53542d)).data("orderInfo", str4), new RouterCallback(this, iLightappInvokerCallback, str2, str3) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ILightappInvokerCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53594b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f53595c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53596d;

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
                    this.f53596d = this;
                    this.a = iLightappInvokerCallback;
                    this.f53594b = str2;
                    this.f53595c = str3;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0) {
                            if (hashMap == null || hashMap.size() <= 0) {
                                return;
                            }
                            int intValue = ((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue();
                            String str5 = (String) hashMap.get("params");
                            if (intValue == 0) {
                                this.a.onResult(0, str5);
                                return;
                            }
                            ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                            String str6 = this.f53594b;
                            StringBuilder sb = new StringBuilder();
                            sb.append("#");
                            sb.append(TextUtils.isEmpty(this.f53595c) ? "doBindCard" : this.f53595c);
                            sb.append(ActLog.TYPE_FAIL);
                            LightappUtils.onError(iLightappInvokerCallback2, str6, LightappConstants.ERRCODE_CANCEL, str5, sb.toString());
                            return;
                        }
                        String str7 = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback3 = this.a;
                        String str8 = this.f53594b;
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
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterDoRnAuth").data(getUrlParam(str3)), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ILightappInvokerCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53599b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53600c;

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
                    this.f53600c = this;
                    this.a = iLightappInvokerCallback;
                    this.f53599b = str2;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0) {
                            if (hashMap == null || hashMap.size() <= 0) {
                                return;
                            }
                            int intValue = ((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue();
                            String str4 = (String) hashMap.get("authDesc");
                            if (intValue == 0) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("result", intValue);
                                    jSONObject.put("cnt", str4);
                                } catch (JSONException e4) {
                                    e4.printStackTrace();
                                }
                                this.a.onResult(0, jSONObject.toString());
                                return;
                            }
                            LightappUtils.onError(this.a, this.f53599b, Integer.toString(intValue), str4, "#doRnAuthFail");
                            return;
                        }
                        String str5 = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                        String str6 = this.f53599b;
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
            this.f53542d = false;
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
                        this.f53542d = ((Boolean) jSONObject.get("showDialog")).booleanValue();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterDoPayWithParams").data("orderInfo", str3).data("showDialog", Boolean.valueOf(this.f53542d)), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ILightappInvokerCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53592b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53593c;

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
                    this.f53593c = this;
                    this.a = iLightappInvokerCallback;
                    this.f53592b = str2;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0) {
                            if (hashMap == null || hashMap.size() <= 0) {
                                return;
                            }
                            int intValue = ((Integer) hashMap.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue();
                            String str4 = (String) hashMap.get("payDesc");
                            if (intValue != 0 && intValue != 1) {
                                this.a.onResult(1, str4);
                                return;
                            } else {
                                this.a.onResult(0, str4);
                                return;
                            }
                        }
                        String str5 = (String) hashMap.get("errorMsg");
                        ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                        String str6 = this.f53592b;
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
        String str = this.a;
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
            if (d(METHOD_CALL_QRCODE_SCANNER)) {
                hashSet.add(METHOD_CALL_QRCODE_SCANNER);
            }
            hashSet.add(METHOD_CALL_ID_PHOTOS);
            if (d("detectBankCard")) {
                hashSet.add("detectBankCard");
            }
            if (d(METHOD_DETECT_LIVENESS)) {
                hashSet.add(METHOD_DETECT_LIVENESS);
            }
            hashSet.add(METHOD_INIT_PAY);
            hashSet.add("dopay");
            hashSet.add("doBindCard");
            hashSet.add("doRnAuth");
            hashSet.add(METHOD_BD_LOGIN);
            hashSet.add(MTD_LIST_MY_BANK_CARD);
            hashSet.add("getPayMethod");
            hashSet.add("changePayMethod");
            hashSet.add("preOrderPay");
            hashSet.add("postEvent");
            hashSet.add(MTD_BINDCARD_INITIATIVE);
            hashSet.add(MTD_BINDCARD_INDEPENDENT);
            hashSet.add("setRnAuthResult");
            hashSet.add(MTD_GOTO_DXM_PAY_SERVICE);
            hashSet.add(METHOD_ACCESS_WALLET_SERVICE);
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
            hashSet.add("selectPhonefromAdressBook");
            hashSet.add(MTD_CUSTOMER_SERVICE);
            hashSet.add(MTD_START_AUDIO_RECORD);
            hashSet.add(MTD_END_AUDIO_RECORD);
            hashSet.add(MTD_GET_SUPPORT_LIST);
            hashSet.add(MTD_SET_FULLSCREEN);
            hashSet.add(METHOD_GET_SUPPORT_LIVENESS);
            hashSet.add(MTD_CALL_NATIVE_PHOTO);
            hashSet.add(MTD_GET_LOAD_TIME_LINE);
            hashSet.add(MTD_GO_TO_APP_SETTING);
            hashSet.add(MTD_OPEN_NEW_LIGHT_BRIDGE);
            hashSet.add(MTD_SEND_TO_SMS);
            hashSet.add(MTD_GET_PERMISSION_STATE);
            hashSet.add(MTD_GET_PERMISSIOM_DIALOG_MSG);
            hashSet.add(MTD_GET_OFFLINE_INFO);
            hashSet.add(MTD_UPLOAD_MSG);
            hashSet.add(MTD_SETSUBMENU);
            hashSet.add(MTD_UNREGISTER_H5_GO_BACK);
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
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterGetPayMethod").data("options", str), new RouterCallback(this, iLightappInvokerCallback) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ILightappInvokerCallback a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ LightappBusinessClient f53560b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iLightappInvokerCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53560b = this;
                this.a = iLightappInvokerCallback;
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
                        this.a.onResult(0, str3);
                    } else {
                        this.a.onResult(1, str3);
                    }
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
            String ua = BussinessUtils.getUA(context);
            if (LightappUtils.parseJsonInt(str, "base64") == f53540b) {
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
            if (!TextUtils.isEmpty(str)) {
                try {
                    str3 = (String) new JSONObject(str).get(LightappConstants.INIT_PAY_PARAM_INIT_PARAM);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                new HashMap().put(ShareLoginStat.GetShareListStat.VALUE_FROM_SP, str3);
            }
            str3 = "";
            new HashMap().put(ShareLoginStat.GetShareListStat.VALUE_FROM_SP, str3);
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
                    if (!LocalRouter.getInstance(context).isProviderExisted("saoyisao")) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_not_include_tips"));
                    } else {
                        callQRCodeScanner(context, str, iLightappInvokerCallback, str3);
                    }
                } else if (METHOD_CALL_ID_PHOTOS.equals(str2)) {
                    callIDPotos(context, str, iLightappInvokerCallback, str3);
                } else if ("detectBankCard".equals(str2)) {
                    detectBankCard(context, str, iLightappInvokerCallback, str3);
                } else if (METHOD_INIT_PAY.equals(str2)) {
                    initpay(context, str, iLightappInvokerCallback, str3);
                } else if ("dopay".equals(str2)) {
                    dopay(context, str, iLightappInvokerCallback, str3);
                } else if ("doBindCard".equals(str2)) {
                    doBindCard(context, str, iLightappInvokerCallback, str3, null);
                } else if ("doRnAuth".equals(str2)) {
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
                } else if ("setRnAuthResult".equals(str2)) {
                    setRnAuthResultInMainThread(context, str, iLightappInvokerCallback, str3);
                } else if ("postEvent".equals(str2)) {
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
                    C(context, str, iLightappInvokerCallback, str3);
                } else if (MTD_GO_TO_APP_SETTING.equals(str2)) {
                    b(context, jSONObject);
                } else if (MTD_SEND_TO_SMS.equals(str2)) {
                    z(context, str, iLightappInvokerCallback, str3);
                } else if (MTD_GET_PERMISSION_STATE.equals(str2)) {
                    B(context, str, iLightappInvokerCallback, str3);
                } else if (MTD_GET_PERMISSIOM_DIALOG_MSG.equals(str2)) {
                    A(context, str, iLightappInvokerCallback, str3);
                } else if (MTD_OPEN_NEW_LIGHT_BRIDGE.equals(str2)) {
                    a(context, jSONObject, iLightappInvokerCallback, str3);
                } else if (MTD_GOTO_DXM_PAY_SERVICE.equals(str2)) {
                    D(context, str, iLightappInvokerCallback, str3);
                } else if (MTD_SETSUBMENU.equals(str2)) {
                    E(context, str, iLightappInvokerCallback, str3);
                } else if (MTD_UNREGISTER_H5_GO_BACK.equals(str2)) {
                    setH5BackCb(null);
                } else {
                    DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.LIGHT_INVOKE_METHOD_NOT_SUPPORT, Arrays.asList(str));
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

    @Override // com.baidu.wallet.lightapp.business.presenter.b
    public void onContactsSelected(String str, int i2, String[] strArr, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, Integer.valueOf(i2), strArr, str2, str3}) == null) {
            ContactSelectModel contactSelectModel = new ContactSelectModel();
            if (i2 != 0) {
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
                ContactSelectModel.SelectedContact selectedContact = contactSelectModel.cnt.selected;
                selectedContact.name = str4;
                selectedContact.phone = str5;
                if (q == v) {
                    PhoneContactsMananger.a(getActivity()).a(new PhoneContactsMananger.d(this, contactSelectModel) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.13
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ContactSelectModel a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ LightappBusinessClient f53559b;

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
                            this.f53559b = this;
                            this.a = contactSelectModel;
                        }

                        @Override // com.baidu.wallet.lightapp.base.contacts.PhoneContactsMananger.d
                        public void a(List<ContactSelectModel.AllContact> list, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, list, i3) == null) {
                                if (LightappBusinessClient.t != null) {
                                    this.a.cnt.abc = Base64Utils.encodeToString(Crypto.aesEncrypt(JsonUtils.toJson(list).getBytes(), LightappBusinessClient.t));
                                } else {
                                    this.a.cnt.all = list;
                                }
                                if (LightappBusinessClient.s != LightappBusinessClient.A) {
                                    this.f53559b.a("selectPhonefromAdressBook", 0, this.a.toJson());
                                    return;
                                }
                                LightAppContactSelectModelBase64 lightAppContactSelectModelBase64 = new LightAppContactSelectModelBase64();
                                ContactSelectModel contactSelectModel2 = this.a;
                                lightAppContactSelectModelBase64.result = contactSelectModel2.result;
                                ContactSelectModel.Data data = contactSelectModel2.cnt;
                                if (data != null) {
                                    lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data).getBytes());
                                }
                                this.f53559b.a("selectPhonefromAdressBook", 0, lightAppContactSelectModelBase64.toJson());
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
                    ContactSelectModel.Data data = contactSelectModel.cnt;
                    if (data != null) {
                        lightAppContactSelectModelBase64.cnt = Base64Utils.encodeToString(JsonUtils.toJson(data).getBytes());
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
        if (interceptable == null || interceptable.invokeLILL(1048603, this, str, i2, strArr, iArr) == null) {
            int i3 = 0;
            if (244 == i2) {
                b bVar = this.F.get(MTD_START_AUDIO_RECORD);
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    while (i3 < strArr.length) {
                        if (PermissionRequest.RESOURCE_AUDIO_CAPTURE.equals(strArr[i3])) {
                            if (bVar != null) {
                                b(bVar.a, bVar.f53632b, bVar.f53633c, bVar.f53634d);
                                return;
                            }
                            return;
                        }
                        i3++;
                    }
                    return;
                }
                LightappUtils.onError(bVar != null ? bVar.f53633c : null, str, LightappConstants.ERRCODE_NO_PERMISSION, "无录音权限", "startRecordingFail");
            } else if (243 == i2) {
                if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                    while (i3 < strArr.length) {
                        if ("android.permission.READ_CONTACTS".equalsIgnoreCase(strArr[i3])) {
                            if (i3 < iArr.length) {
                                int i4 = iArr[i3];
                                if (i4 != 0) {
                                    if (i4 == -1) {
                                        b(str);
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
                b(str);
            } else if (245 != i2 && 246 != i2) {
                if (i2 == 4) {
                    if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                        while (i3 < strArr.length) {
                            if (s.f57425i.equalsIgnoreCase(strArr[i3]) && i3 < iArr.length && iArr[i3] == -1) {
                                b(MTD_CALL_NATIVE_PHOTO, "没有存储权限");
                                return;
                            }
                            i3++;
                        }
                        if (this.p.contains("multipleMaxCount")) {
                            a(getActivity(), this.p, str);
                            return;
                        } else {
                            this.B.loadAlubm(this.p);
                            return;
                        }
                    }
                    b(MTD_CALL_NATIVE_PHOTO, "没有存储权限");
                }
            } else if (strArr != null && iArr != null && strArr.length != 0 && iArr.length != 0) {
                while (i3 < strArr.length) {
                    if (PermissionRequest.RESOURCE_VIDEO_CAPTURE.equalsIgnoreCase(strArr[i3])) {
                        if (i3 < iArr.length && iArr[i3] == -1) {
                            c("没有相机权限");
                            return;
                        }
                    } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i3]) && i3 < iArr.length && iArr[i3] == -1) {
                        c("没有存储权限");
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
                c("没有相机和存储权限");
            }
        }
    }

    public void postEvent(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, context, str, iLightappInvokerCallback, str2) == null) {
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
                LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterDoPostEvent").data("event_key", string).data("event_value", string2), new RouterCallback(this) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LightappBusinessClient a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        }
                    }
                });
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
        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterPreOrderPay").data("options", str), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ILightappInvokerCallback a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f53563b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LightappBusinessClient f53564c;

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
                this.f53564c = this;
                this.a = iLightappInvokerCallback;
                this.f53563b = str2;
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
                                this.a.onResult(0, str3);
                            } else {
                                this.a.onResult(1, str3);
                            }
                            return;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    String str4 = (String) hashMap.get("errorMsg");
                    ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                    String str5 = this.f53563b;
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
            String str = this.a;
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
                        LogUtil.d("langbrige", "setRnAuthResult OK");
                        LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("dxmPay").action("enterSetRnAuthResult").data(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, Integer.valueOf(intValue)).data("desc", str4), new RouterCallback(this, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ILightappInvokerCallback a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f53601b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ LightappBusinessClient f53602c;

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
                                this.f53602c = this;
                                this.a = iLightappInvokerCallback;
                                this.f53601b = str2;
                            }

                            @Override // com.baidu.wallet.router.RouterCallback
                            public void onResult(int i3, HashMap hashMap) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                                    if (i3 != 0) {
                                        LightappUtils.onError(this.a, this.f53601b, Integer.toString(i3), "invoke_method_fail_from_router", "#setRnAuthResultFail");
                                        return;
                                    }
                                    String str5 = (String) hashMap.get("errorMsg");
                                    ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                                    String str6 = this.f53601b;
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
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53576b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f53577c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f53578d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53579e;

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
                    this.f53579e = this;
                    this.a = context;
                    this.f53576b = str;
                    this.f53577c = iLightappInvokerCallback;
                    this.f53578d = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f53579e.setRnAuthResult(this.a, this.f53576b, this.f53577c, this.f53578d);
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
        if (interceptable == null || interceptable.invokeLLLL(65579, this, context, str, iLightappInvokerCallback, str2) == null) {
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

    private void c(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65576, this, context, str, iLightappInvokerCallback, str2) == null) {
            a aVar = new a(this);
            aVar.f53627e = iLightappInvokerCallback;
            aVar.f53629g = str2;
            this.E.obtainMessage(2, aVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, aVar) == null) {
            try {
                AudioRecorder.getInstance().end();
                aVar.f53627e.onResult(0, "{\"result\":0}");
            } catch (Exception e2) {
                LightappUtils.onError(aVar.f53627e, aVar.f53629g, LightappConstants.ERRCODE_INNER_ERROR, e2.getLocalizedMessage(), "endRecordingFail");
            }
        }
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, str) == null) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = str;
            a("callNativeVoice", 1, lightAppErrorModel.toJson());
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, this, str, str2) == null) {
            LogUtil.logd("method:" + str + "options=" + str2);
        }
    }

    private void a(Context context, int i2, ILightappInvokerCallback iLightappInvokerCallback, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{context, Integer.valueOf(i2), iLightappInvokerCallback, str, Boolean.valueOf(z)}) == null) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("idcarddetect").action("enterIdCardDetect").data("type", Integer.valueOf(i2)).data("showAlbum", Boolean.valueOf(z)), new AnonymousClass12(this, iLightappInvokerCallback, str, context));
        }
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65566, this, context, str, iLightappInvokerCallback, str2) == null) {
            try {
                if (PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("callback", null);
                    if (LightappJsClient.isJsFunNameValid(optString)) {
                        a aVar = new a(this);
                        if (!SdpPrefer.AUDIO_STEREO.equals(jSONObject.optString("channelType", "mono"))) {
                            aVar.f53624b = 16;
                        } else {
                            aVar.f53624b = 12;
                        }
                        int optInt = jSONObject.optInt("samplingAccuracy", 16);
                        aVar.f53625c = optInt;
                        if (8 != optInt) {
                            aVar.f53625c = 2;
                        } else {
                            aVar.f53625c = 3;
                        }
                        aVar.a = jSONObject.optInt("samplingRate", 8000);
                        aVar.f53626d = jSONObject.optInt("maxChunkSize", 2048);
                        aVar.f53628f = optString;
                        aVar.f53627e = iLightappInvokerCallback;
                        aVar.f53629g = str2;
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, IPUT, MOVE_EXCEPTION] complete} */
    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) {
            if (!this.y) {
                try {
                    this.f53549k = Class.forName("com.sensetime.liveness.motion.api.SenseLiveness");
                    Class<?> cls = Class.forName("com.sensetime.liveness.motion.api.SenseLivenessCallback");
                    this.m = cls;
                    this.l = this.f53549k.getDeclaredMethod("startDetect", Context.class, String.class, cls);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            return (this.f53549k == null || this.m == null || this.l == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, aVar) == null) {
            try {
                if (getActivity() != null) {
                    AudioRecorder audioRecorder = AudioRecorder.getInstance();
                    if (audioRecorder.init(aVar.a, aVar.f53624b, aVar.f53625c, aVar.f53626d)) {
                        aVar.f53630h = UUID.randomUUID().toString();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", 0);
                        jSONObject.put("recordId", aVar.f53630h);
                        aVar.f53627e.onResult(0, jSONObject.toString());
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("recordId", aVar.f53630h);
                        jSONObject2.put("hasNext", 1);
                        audioRecorder.addObserver(new Observer(this, audioRecorder, aVar, jSONObject2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public AudioVolume a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AudioRecorder f53606b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ a f53607c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ JSONObject f53608d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ LightappBusinessClient f53609e;

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
                                this.f53609e = this;
                                this.f53606b = audioRecorder;
                                this.f53607c = aVar;
                                this.f53608d = jSONObject2;
                                this.a = new AudioVolume(4000);
                            }

                            @Override // java.util.Observer
                            public void update(Observable observable, Object obj) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, observable, obj) == null) && this.f53606b == observable && this.f53609e.getActivity() != null) {
                                    if (obj instanceof ByteBuffer) {
                                        ByteBuffer byteBuffer = (ByteBuffer) obj;
                                        this.a.calAccumulatedVolume(byteBuffer, 2 == this.f53607c.f53625c);
                                        try {
                                            this.f53608d.put("volume", this.a.getVolume());
                                            LogUtil.d("volume", "update: " + this.a);
                                            this.f53608d.put("data", Base64.encodeToString(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining(), 2));
                                            this.f53609e.getActivity().runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5.1
                                                public static /* synthetic */ Interceptable $ic;
                                                public transient /* synthetic */ FieldHolder $fh;
                                                public final /* synthetic */ AnonymousClass5 a;

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
                                                    this.a = this;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    Interceptable interceptable3 = $ic;
                                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                        try {
                                                            this.a.f53609e.B.executeJsFunction(this.a.f53607c.f53628f, this.a.f53608d.toString());
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
                                                this.f53608d.put("hasNext", 0);
                                                this.f53608d.remove("data");
                                                this.f53608d.remove("volume");
                                                this.f53609e.getActivity().runOnUiThread(new Runnable(this) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.5.2
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;
                                                    public final /* synthetic */ AnonymousClass5 a;

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
                                                        this.a = this;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                            try {
                                                                this.a.f53609e.B.executeJsFunction(this.a.f53607c.f53628f, this.a.f53608d.toString());
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
                LightappUtils.onError(aVar.f53627e, aVar.f53629g, LightappConstants.ERRCODE_INNER_ERROR, e2.getLocalizedMessage(), "startRecordingFail");
            }
        }
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, this, str)) == null) ? a(str, -1L, "") : invokeL.booleanValue;
    }

    private void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, this, context, str, iLightappInvokerCallback, str2) == null) {
            if (!PermissionManager.checkCallingPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                BaiduWalletUtils.requestPermissionsDialog("wallet_langbridge", getActivity(), new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, new BaiduWalletUtils.IRequestPermissionCallBack(this, context, str, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f53610b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ ILightappInvokerCallback f53611c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f53612d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f53613e;

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
                        this.f53613e = this;
                        this.a = context;
                        this.f53610b = str;
                        this.f53611c = iLightappInvokerCallback;
                        this.f53612d = str2;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (this.f53613e.F == null) {
                                this.f53613e.F = new HashMap();
                            }
                            this.f53613e.F.put(LightappBusinessClient.MTD_START_AUDIO_RECORD, new b(this.f53613e, this.a, this.f53610b, this.f53611c, this.f53612d));
                            if (bool.booleanValue()) {
                                if (PermissionManager.checkCallingOrSelfPermission(this.f53613e.getActivity(), new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 244)) {
                                    return;
                                }
                                LightappUtils.onError(this.f53611c, this.f53612d, LightappConstants.ERRCODE_NO_PERMISSION, "无录音权限", "startRecordingFail");
                                return;
                            }
                            this.f53613e.onRequestPermissionsResult("", 244, new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, new int[]{-1});
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

    private void b(Context context, HashMap hashMap, ILightappInvokerCallback iLightappInvokerCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, this, context, hashMap, iLightappInvokerCallback, str) == null) {
            DXMBioRecogSDK.getInstance().invokeDxmFaceSDK(context, hashMap, new DXMFaceLivenessCallback(this, iLightappInvokerCallback, str, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ILightappInvokerCallback a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53617b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f53618c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53619d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLightappInvokerCallback, str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53619d = this;
                    this.a = iLightappInvokerCallback;
                    this.f53617b = str;
                    this.f53618c = context;
                }

                public void onResult(int i2, HashMap hashMap2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) {
                        if (i2 == 0) {
                            LightAppCommonModel lightAppCommonModel = new LightAppCommonModel(0);
                            lightAppCommonModel.cnt.errCode = String.valueOf(0);
                            LightAppCommonModel.Data data = lightAppCommonModel.cnt;
                            data.des = "成功";
                            data.data = hashMap2;
                            this.a.onResult(0, lightAppCommonModel.toJson());
                            return;
                        }
                        ILightappInvokerCallback iLightappInvokerCallback2 = this.a;
                        String str2 = this.f53617b;
                        String valueOf = String.valueOf(i2);
                        LightappUtils.onError(iLightappInvokerCallback2, str2, valueOf, PhoneUtils.getApplicationName(this.f53618c) + hashMap2.get("msg"), "#identifyAuthFail");
                    }
                }
            });
        }
    }

    private void a(Context context, HashMap hashMap, ILightappInvokerCallback iLightappInvokerCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65554, this, context, hashMap, iLightappInvokerCallback, str) == null) {
            if (LocalRouter.getInstance(context).isProviderExisted("livenessidentifyauth")) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("livenessidentifyauth").action("livenessidentifyauth").data(hashMap), new RouterCallback(this, iLightappInvokerCallback, str, context) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ILightappInvokerCallback a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f53614b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Context f53615c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ LightappBusinessClient f53616d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iLightappInvokerCallback, str, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f53616d = this;
                        this.a = iLightappInvokerCallback;
                        this.f53614b = str;
                        this.f53615c = context;
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
                                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap3.values());
                                    LightappUtils.onError(this.a, this.f53614b, "10004", "没有找到对应的方法", "#identifyAuthFail");
                                    return;
                                }
                                LightappUtils.onError(this.a, this.f53614b, i2 + "", PhoneUtils.getApplicationName(this.f53615c) + ((String) hashMap2.get("errorMsg")), "#identifyAuthFail");
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
                                    this.a.onResult(0, lightAppCommonModel.toJson());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                    LightappUtils.onError(this.a, this.f53614b, i2 + "", PhoneUtils.getApplicationName(this.f53615c) + ((String) hashMap2.get("errorMsg")), "#identifyAuthFail");
                                }
                            }
                        }
                    }
                });
            } else {
                LightappUtils.onError(iLightappInvokerCallback, str, "10004", "没有找到对应的方法", "#identifyAuthFail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, str) == null) {
            ContactSelectModel contactSelectModel = new ContactSelectModel(1);
            ContactSelectModel.Data data = contactSelectModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = PhoneUtils.getApplicationName(getActivity()) + "没有访问通信录的权限";
            a("selectPhonefromAdressBook", 1, contactSelectModel.toJson());
        }
    }

    private void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65573, this, str, str2) == null) {
            LightAppErrorModel lightAppErrorModel = new LightAppErrorModel(1);
            LightAppErrorModel.Data data = lightAppErrorModel.cnt;
            data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
            data.des = str2;
            a(str, 1, lightAppErrorModel.toJson());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, CONST_STR, CONST_STR, INVOKE, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, IPUT, MOVE_EXCEPTION] complete} */
    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, str)) == null) {
            if (!this.w) {
                try {
                    this.f53543e = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                    Class<?> cls = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                    this.f53545g = cls;
                    this.f53544f = this.f53543e.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, Context.class, String.class, Boolean.TYPE, cls);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            return (this.f53543e == null || this.f53545g == null || this.f53544f == null) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private void b(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, this, new Object[]{context, str, iLightappInvokerCallback, str2, Boolean.valueOf(z)}) == null) {
            doBindCard(context, str, iLightappInvokerCallback, str2, z ? MTD_BINDCARD_INDEPENDENT : MTD_BINDCARD_INITIATIVE);
        }
    }

    private void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65569, this, context, jSONObject) == null) || context == null || jSONObject == null) {
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
    public void a(String str, int i2, String str2) {
        ILightappInvokerCallback iLightappInvokerCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65560, this, str, i2, str2) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{context, str, iLightappInvokerCallback, str2, Boolean.valueOf(z)}) == null) {
            String str3 = z ? MTD_ENCRYPT : MTD_DECRYPT;
            if (iLightappInvokerCallback == null) {
                return;
            }
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, context, jSONObject)) == null) {
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
            jSONObject3.put("errCode", 0);
            jSONObject3.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            return LightappUtils.assembleResult(0, jSONObject3);
        }
        return (String) invokeLL.objValue;
    }

    private void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, this, context, str, str2) == null) {
            int i2 = 0;
            try {
                i2 = new JSONObject(str).optInt("multipleMaxCount");
                String str3 = this.a;
                LogUtil.d(str3, "callMultiNativePhotos maxCOunt = " + i2);
                if (i2 > SdkInitResponse.getInstance().getMultipleMaxCount() || i2 <= 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errCode", LightappConstants.ERRCODE_INVALID_PARAMETER);
                    jSONObject.put("des", "参数异常");
                    a(MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject));
                    return;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider("imageselector").action("enterLocalImageSel").data("multipleMaxCount", Integer.valueOf(i2)), new RouterCallback(this, context, str2, str) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f53567b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f53568c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ LightappBusinessClient f53569d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str2, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53569d = this;
                    this.a = context;
                    this.f53567b = str2;
                    this.f53568c = str;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i3, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) {
                        if (i3 != 0) {
                            if (i3 == 5) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("errCode", "10004");
                                    jSONObject2.put("des", "不支持该能力");
                                    this.f53569d.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject2));
                                    return;
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("errCode", LightappConstants.ERRCODE_CANCEL);
                                jSONObject3.put("des", "用户取消选择");
                                this.f53569d.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject3));
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        } else if (hashMap != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            JSONObject jSONObject5 = new JSONObject();
                            List list = (List) hashMap.get("data");
                            ArrayList arrayList = new ArrayList();
                            long currentTimeMillis = System.currentTimeMillis();
                            if (list == null || list.size() <= 0) {
                                return;
                            }
                            for (Object obj : list) {
                                if (obj != null && (obj instanceof Uri)) {
                                    ImageBase64Utils.getInstance().getImageBase64(this.a, (Uri) obj, -1, 100, new ImageBase64Utils.ImageBase64Listener(this, obj, arrayList, list, currentTimeMillis, jSONObject5, jSONObject4) { // from class: com.baidu.wallet.lightapp.business.LightappBusinessClient.19.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ Object a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ List f53570b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ List f53571c;

                                        /* renamed from: d  reason: collision with root package name */
                                        public final /* synthetic */ long f53572d;

                                        /* renamed from: e  reason: collision with root package name */
                                        public final /* synthetic */ JSONObject f53573e;

                                        /* renamed from: f  reason: collision with root package name */
                                        public final /* synthetic */ JSONObject f53574f;

                                        /* renamed from: g  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass19 f53575g;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, obj, arrayList, list, Long.valueOf(currentTimeMillis), jSONObject5, jSONObject4};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i4 = newInitContext.flag;
                                                if ((i4 & 1) != 0) {
                                                    int i5 = i4 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f53575g = this;
                                            this.a = obj;
                                            this.f53570b = arrayList;
                                            this.f53571c = list;
                                            this.f53572d = currentTimeMillis;
                                            this.f53573e = jSONObject5;
                                            this.f53574f = jSONObject4;
                                        }

                                        @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                                        public void onBase64Result(String str4) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, str4) == null) {
                                                LogUtil.d("album", "uri = " + this.a + " ; ThreadName =  " + Thread.currentThread().getName());
                                                if (!TextUtils.isEmpty(str4)) {
                                                    this.f53570b.add(str4);
                                                    if (this.f53570b.size() == this.f53571c.size()) {
                                                        LogUtil.d("album", "success cost = " + (System.currentTimeMillis() - this.f53572d));
                                                        try {
                                                            this.f53573e.put(TbConfig.LOCAL_PIC_DIR, new JSONArray((Collection) this.f53570b));
                                                            this.f53574f.put("data", this.f53573e);
                                                            this.f53574f.put("errCode", 0);
                                                            this.f53574f.put("des", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                                                        } catch (JSONException e5) {
                                                            e5.printStackTrace();
                                                        }
                                                        AnonymousClass19 anonymousClass19 = this.f53575g;
                                                        DXMSdkSAUtils.onEventWithValues(LightAppStatEvent.MTD_CALL_NATIVE_PHOTO_MULTI_RESULT, Arrays.asList(anonymousClass19.f53567b, LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, anonymousClass19.f53568c, String.valueOf(this.f53570b.size())));
                                                        this.f53575g.f53569d.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 0, LightappUtils.assembleResult(0, this.f53574f));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                try {
                                                    JSONObject jSONObject6 = new JSONObject();
                                                    jSONObject6.put("errCode", LightappConstants.ERRCODE_INNER_ERROR);
                                                    jSONObject6.put("des", "读取图片数据异常");
                                                    this.f53575g.f53569d.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject6));
                                                } catch (JSONException e6) {
                                                    e6.printStackTrace();
                                                }
                                            }
                                        }
                                    });
                                } else {
                                    try {
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put("errCode", LightappConstants.ERRCODE_INNER_ERROR);
                                        jSONObject6.put("des", "内部错误");
                                        this.f53569d.a(LightappBusinessClient.MTD_CALL_NATIVE_PHOTO, 1, LightappUtils.assembleResult(1, jSONObject6));
                                    } catch (JSONException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, JSONObject jSONObject, ILightappInvokerCallback iLightappInvokerCallback, String str) {
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str3;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65555, this, context, jSONObject, iLightappInvokerCallback, str) == null) {
            String str4 = "";
            if (context == null && jSONObject == null) {
                return;
            }
            try {
                str2 = jSONObject.getString("link_addr");
            } catch (JSONException e2) {
                e2.printStackTrace();
                LightappUtils.onError(iLightappInvokerCallback, str, LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate urls", "#openInNewLightBridgeFail");
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                LightappUtils.onError(iLightappInvokerCallback, str, LightappConstants.ERRCODE_INVALID_PARAMETER, "invalidate urls", "#openInNewLightBridgeFail");
            }
            if (TextUtils.isEmpty(jSONObject.optString("extra_param"))) {
                str3 = "";
                z3 = false;
                z4 = false;
            } else {
                try {
                    z = jSONObject.getBoolean("withAnim");
                    try {
                        z2 = jSONObject.getBoolean("showShar");
                        try {
                            str4 = jSONObject.getString("title");
                        } catch (JSONException e3) {
                            e = e3;
                            e.printStackTrace();
                            z3 = z;
                            z4 = z2;
                            str3 = str4;
                            this.B.startNewLightApp(context, str2, str3, z3, z4);
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("des", "参数合法，尝试打开");
                            if (iLightappInvokerCallback != null) {
                            }
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        z2 = false;
                        e.printStackTrace();
                        z3 = z;
                        z4 = z2;
                        str3 = str4;
                        this.B.startNewLightApp(context, str2, str3, z3, z4);
                        jSONObject2 = new JSONObject();
                        jSONObject2.put("des", "参数合法，尝试打开");
                        if (iLightappInvokerCallback != null) {
                        }
                    }
                } catch (JSONException e5) {
                    e = e5;
                    z = false;
                }
                z3 = z;
                z4 = z2;
                str3 = str4;
            }
            this.B.startNewLightApp(context, str2, str3, z3, z4);
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("des", "参数合法，尝试打开");
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, LightappUtils.assembleResult(0, jSONObject2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, context, str)) == null) {
            return PhoneUtils.getApplicationName(context) + "没有" + str;
        }
        return (String) invokeLL.objValue;
    }

    private boolean a(String str, long j2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, this, new Object[]{str, Long.valueOf(j2), str2})) == null) {
            if (METHOD_CALL_QRCODE_SCANNER.equals(str)) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("saoyisao").action("qrcodescanresult").data("type", Integer.valueOf(LightappUtils.parseJsonInt(str2, "type"))));
            }
            if ("detectBankCard".equals(str)) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("bankdetection").action("bankcarddetction"));
            }
            if (METHOD_DETECT_LIVENESS.equals(str)) {
                return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("livenessdetect").action("livenessdetect"));
            }
            if (METHOD_ACCESS_WALLET_SERVICE.equals(str)) {
                if (j2 == SVC_ID_H5_HOMEPAGE) {
                    return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("home").action("wallethome"));
                }
                if (j2 == SVC_ID_H5_BALANCE || j2 == SVC_ID_H5_TRANSERECORD || j2 == SVC_ID_H5_COUPON || j2 == SVC_ID_H5_MYBANKCARD || j2 == SVC_ID_H5_SECURITCENTER || j2 == SVC_ID_H5_CASHBACK) {
                    return true;
                }
                if (j2 == SVC_ID_H5_CHARGE) {
                    return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("fastpay").action("doPhoneCharge"));
                }
                if (j2 == SVC_ID_H5_TRANSFER) {
                    return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("transfer").action("entertransfer"));
                }
                if (j2 == SVC_ID_H5_SCANQR) {
                    return LocalRouter.getInstance(getActivity()).isRequestAvailable(new RouterRequest().provider("saoyisao").action("qrcodescanner").data("type", Integer.valueOf(LightappUtils.parseJsonInt(str2, "type"))));
                }
                return j2 == SVC_ID_H5_QRGEN || j2 == 10013 || j2 == SVC_ID_H5_PAY_SET || j2 == SVC_ID_H5_PWD_SET || j2 == -1;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
