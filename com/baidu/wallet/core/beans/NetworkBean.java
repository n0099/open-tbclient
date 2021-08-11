package com.baidu.wallet.core.beans;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.ApollonBean;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.utils.BdWalletUtils;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class NetworkBean<T> extends ApollonBean<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String PARAM_API_SIG = "sign";
    public static final String PARAM_COOKIE = "atbc";
    public static final String PARAM_CUID = "cuid_1";
    public static final String PARAM_CUID_2 = "cuid_2";
    public static final String PARAM_FKWCP = "fk_wcp";
    public static final String PARAM_FROM = "from";
    public static final String PARAM_IE = "_ie";
    public static final String PARAM_IMEI_NEW = "wime";
    public static final String PARAM_NETTYPE = "nettype";
    public static final String PARAM_NEW_COOKIE = "natbc";
    public static final String PARAM_UA = "ua";
    public static final String TAG = "NetworkBean";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.core.beans.NetworkBean$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class BizType {
        public static final /* synthetic */ BizType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BizType BackwardComp;
        public static final BizType BindCard;
        public static final BizType Pwd;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-894723896, "Lcom/baidu/wallet/core/beans/NetworkBean$BizType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-894723896, "Lcom/baidu/wallet/core/beans/NetworkBean$BizType;");
                    return;
                }
            }
            BackwardComp = new BizType("BackwardComp", 0);
            BindCard = new BizType("BindCard", 1);
            BizType bizType = new BizType("Pwd", 2);
            Pwd = bizType;
            $VALUES = new BizType[]{BackwardComp, BindCard, bizType};
        }

        public BizType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BizType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BizType) Enum.valueOf(BizType.class, str) : (BizType) invokeL.objValue;
        }

        public static BizType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BizType[]) $VALUES.clone() : (BizType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class SessionCache implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<Integer, BeanResponseBase.Session> mCache;

        /* loaded from: classes8.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static final SessionCache f60563a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1887557128, "Lcom/baidu/wallet/core/beans/NetworkBean$SessionCache$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1887557128, "Lcom/baidu/wallet/core/beans/NetworkBean$SessionCache$a;");
                        return;
                    }
                }
                f60563a = new SessionCache(null);
            }

            public a() {
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
        }

        public /* synthetic */ SessionCache(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static SessionCache getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f60563a : (SessionCache) invokeV.objValue;
        }

        public static synchronized void sync(SessionCache sessionCache) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, sessionCache) == null) {
                synchronized (SessionCache.class) {
                    if (sessionCache != null) {
                        a.f60563a.mCache = sessionCache.mCache;
                    }
                }
            }
        }

        public String getSessionId(BizType bizType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bizType)) == null) {
                if (bizType == null) {
                    bizType = BizType.BackwardComp;
                }
                BeanResponseBase.Session session = this.mCache.get(Integer.valueOf(bizType.ordinal()));
                if (session == null) {
                    return null;
                }
                return session.session_id;
            }
            return (String) invokeL.objValue;
        }

        public boolean matchSessionUri(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str == null) {
                    return false;
                }
                BeanResponseBase.Session session = this.mCache.get(Integer.valueOf(BizType.BackwardComp.ordinal()));
                String[] strArr = session == null ? null : session.session_uri;
                if (strArr == null) {
                    return false;
                }
                for (String str2 : strArr) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void put(BizType bizType, BeanResponseBase.Session session) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bizType, session) == null) {
                if (session == null) {
                    this.mCache.remove(Integer.valueOf(BizType.BackwardComp.ordinal()));
                } else if (BizType.BackwardComp.ordinal() == session.biz_code) {
                    if ("1".equals(session.delete_flag)) {
                        this.mCache.remove(Integer.valueOf(BizType.BackwardComp.ordinal()));
                    } else {
                        this.mCache.put(Integer.valueOf(BizType.BackwardComp.ordinal()), session);
                    }
                } else {
                    this.mCache.put(Integer.valueOf(bizType == null ? 0 : bizType.ordinal()), session);
                }
            }
        }

        public SessionCache() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCache = new HashMap<>();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void appendCertification(Context context, List<RestNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, list) == null) {
            list.add(new RestNameValuePair("from", "JT"));
            if ("gbk".equals(getEncode())) {
                list.add(new RestNameValuePair(PARAM_IE, "gbk"));
                list.add(new RestNameValuePair("ie", "gbk"));
            } else {
                list.add(new RestNameValuePair(PARAM_IE, "utf-8"));
                list.add(new RestNameValuePair("ie", "utf-8"));
            }
            list.add(new RestNameValuePair("ua", BussinessUtils.getUA(context)));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wime", "");
                jSONObject.put("cuid_1", PayUtils.encrypt("phone_number", PhoneUtils.getCUID(context)));
                jSONObject.put("cuid_2", PayUtils.encrypt("phone_number", PhoneUtils.getCUID2(context)));
                jSONObject.put("fk_wcp", PayUtils.encrypt("phone_number", (((("fp=" + BdWalletUtils.getDeviceFP(this.mContext)) + "&lastModify=" + BdWalletUtils.getFPFileLastModified(this.mContext)) + "&cpuInfo=" + PhoneUtils.getSystemCPUInfo().getCpuPath() + "_" + PhoneUtils.getNumCores()) + "&diskCapacity=" + PhoneUtils.getTotalInternalMemorySize()) + "&upTime=" + (SystemClock.elapsedRealtime() / 1000)));
                jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            list.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
            String str = SafePay.getInstance().getpwProxy();
            boolean z = false;
            Iterator<RestNameValuePair> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if ("key".equals(it.next().getName())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                list.add(new RestNameValuePair("key", str));
            }
            String cookie = PayUtils.getCookie(context);
            LogUtil.w("TEST", "appendCertification(" + context + "|" + cookie + SmallTailInfo.EMOTION_SUFFIX);
            if (!TextUtils.isEmpty(cookie)) {
                list.add(new RestNameValuePair(PARAM_COOKIE, SafePay.getInstance().encryptProxy(cookie)));
            } else {
                list.add(new RestNameValuePair(PARAM_COOKIE, ""));
            }
            String newCookie = PayUtils.getNewCookie(context);
            if (!TextUtils.isEmpty(newCookie)) {
                list.add(new RestNameValuePair(PARAM_NEW_COOKIE, SafePay.getInstance().encryptProxy(newCookie)));
            } else {
                list.add(new RestNameValuePair(PARAM_NEW_COOKIE, ""));
            }
            if (isSign()) {
                list.add(new RestNameValuePair("sign", PayUtils.genAPIsig(list)));
            }
        }
    }

    private List<RestNameValuePair> appendUriParameter(Context context, List<RestNameValuePair> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, list)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            if (getAuthLevel() > 0 && !isLbsPayBean()) {
                appendCertification(context, list);
            }
            if (!containsKey(list, "session_id") && SessionCache.getInstance().matchSessionUri(getUrl()) && !TextUtils.isEmpty(SessionCache.getInstance().getSessionId(null))) {
                list.add(new RestNameValuePair("session_id", SessionCache.getInstance().getSessionId(null)));
            }
            if (needNonce()) {
                list.add(new RestNameValuePair("nonce", PayUtils.getNonce(list)));
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }

    private boolean containsKey(List<RestNameValuePair> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, list, str)) == null) {
            if (list == null) {
                return false;
            }
            for (RestNameValuePair restNameValuePair : list) {
                if (str.equals(restNameValuePair.getName())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract List<RestNameValuePair> generateRequestParam();

    @Override // com.baidu.apollon.beans.ApollonBean
    public List<RestNameValuePair> getRequestParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? appendUriParameter(this.mContext, generateRequestParam()) : (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            LogUtil.d("NetworkBean", "execBean. exception = " + exc);
            if (exc instanceof RestRuntimeException) {
                if (this.mRspCallback != null) {
                    RestRuntimeException restRuntimeException = (RestRuntimeException) exc;
                    if (restRuntimeException.contains(SocketTimeoutException.class)) {
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -15, ResUtils.getString(this.mContext, "ebpay_no_network"));
                    } else if (!restRuntimeException.contains(SSLPeerUnverifiedException.class) && !restRuntimeException.contains(CertificateException.class)) {
                        if (restRuntimeException.contains(IllegalArgumentException.class)) {
                            IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
                            if (iBeanResponseCallback != null) {
                                iBeanResponseCallback.onBeanExecFailure(getBeanId(), -2, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                                return;
                            }
                            return;
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -15, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                    } else {
                        if (exc.getMessage().contains("Pin verification failed")) {
                            String[] strArr = new String[2];
                            strArr[0] = getUrl();
                            strArr[1] = exc.getCause() == null ? exc.getMessage() : exc.getCause().toString();
                            DXMSdkSAUtils.onEventWithValues("#ssl_pinning_error", Arrays.asList(strArr));
                        } else {
                            DXMSdkSAUtils.onEvent("#ssl_certificate_error");
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -16, ResUtils.getString(this.mContext, "ebpay_ssl"));
                    }
                }
            } else if (exc instanceof IllegalArgumentException) {
                IBeanResponseCallback iBeanResponseCallback2 = this.mRspCallback;
                if (iBeanResponseCallback2 != null) {
                    iBeanResponseCallback2.onBeanExecFailure(getBeanId(), -2, ResUtils.getString(this.mContext, "ebpay_resolve_error"));
                }
            } else {
                exc.printStackTrace();
            }
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void handleNetworkFailureError() {
        IBeanResponseCallback iBeanResponseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iBeanResponseCallback = this.mRspCallback) == null) {
            return;
        }
        iBeanResponseCallback.onBeanExecFailure(getBeanId(), -8, ResUtils.getString(this.mContext, "ebpay_no_network"));
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, restResponseEntity) == null) {
            String a2 = restResponseEntity.a("token");
            if (!TextUtils.isEmpty(a2)) {
                AccountManager.getInstance(this.mContext).setBfbToken(a2);
            }
            List<String> headerValue = restResponseEntity.getHeaderValue("Set-Cookie");
            if (headerValue != null) {
                for (int i2 = 0; i2 < headerValue.size(); i2++) {
                    String str = headerValue.get(i2);
                    try {
                        String[] split = str.substring(0, str.indexOf(";")).split("=");
                        if (split.length > 0 && "token".equals(split[0]) && !TextUtils.isEmpty(split[1]) && TextUtils.isEmpty(AccountManager.getInstance(this.mContext).getBfbToken())) {
                            AccountManager.getInstance(this.mContext).setBfbToken(split[1]);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean isLbsPayBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean needNonce();

    public boolean needVerifySignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
