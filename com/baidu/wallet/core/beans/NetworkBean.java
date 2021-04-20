package com.baidu.wallet.core.beans;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.ApollonBean;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.PayUtils;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes5.dex */
public abstract class NetworkBean<T> extends ApollonBean<T> {
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

    /* loaded from: classes5.dex */
    public enum BizType {
        BackwardComp,
        BindCard,
        Pwd
    }

    /* loaded from: classes5.dex */
    public static class SessionCache implements Serializable {
        public HashMap<Integer, BeanResponseBase.Session> mCache;

        /* loaded from: classes5.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SessionCache f23927a = new SessionCache();
        }

        public static SessionCache getInstance() {
            return a.f23927a;
        }

        public static synchronized void sync(SessionCache sessionCache) {
            synchronized (SessionCache.class) {
                if (sessionCache != null) {
                    a.f23927a.mCache = sessionCache.mCache;
                }
            }
        }

        public String getSessionId(BizType bizType) {
            if (bizType == null) {
                bizType = BizType.BackwardComp;
            }
            BeanResponseBase.Session session = this.mCache.get(Integer.valueOf(bizType.ordinal()));
            if (session == null) {
                return null;
            }
            return session.session_id;
        }

        public boolean matchSessionUri(String str) {
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

        public void put(BizType bizType, BeanResponseBase.Session session) {
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

        public SessionCache() {
            this.mCache = new HashMap<>();
        }
    }

    public NetworkBean(Context context) {
        super(context);
    }

    private void appendCertification(Context context, List<RestNameValuePair> list) {
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
        LogUtil.w("TEST", "appendCertification(" + context + FieldBuilder.SE + cookie + SmallTailInfo.EMOTION_SUFFIX);
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

    private List<RestNameValuePair> appendUriParameter(Context context, List<RestNameValuePair> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (getAuthLevel() > 0 && !isLbsPayBean()) {
            appendCertification(context, list);
        }
        if (!containsKey(list, ETAG.KEY_STATISTICS_SEESIONID) && SessionCache.getInstance().matchSessionUri(getUrl()) && !TextUtils.isEmpty(SessionCache.getInstance().getSessionId(null))) {
            list.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, SessionCache.getInstance().getSessionId(null)));
        }
        if (needNonce()) {
            list.add(new RestNameValuePair("nonce", PayUtils.getNonce(list)));
        }
        return list;
    }

    private boolean containsKey(List<RestNameValuePair> list, String str) {
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

    public abstract List<RestNameValuePair> generateRequestParam();

    @Override // com.baidu.apollon.beans.ApollonBean
    public List<RestNameValuePair> getRequestParams() {
        return appendUriParameter(this.mContext, generateRequestParam());
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
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
                        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SSL_PINNING_ERROR, Arrays.asList(strArr));
                        String[] strArr2 = new String[2];
                        strArr2[0] = getUrl();
                        strArr2[1] = exc.getCause() == null ? exc.getMessage() : exc.getCause().toString();
                        PayStatisticsUtil.onEventWithValues(StatServiceEvent.SSL_PINNING_ERROR, Arrays.asList(strArr2));
                    } else {
                        DXMSdkSAUtils.onEvent(StatServiceEvent.SSL_CERTIFICATE_ERROR);
                        PayStatisticsUtil.onEvent(StatServiceEvent.SSL_CERTIFICATE_ERROR);
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

    @Override // com.baidu.apollon.beans.ApollonBean
    public void handleNetworkFailureError() {
        IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
        if (iBeanResponseCallback != null) {
            iBeanResponseCallback.onBeanExecFailure(getBeanId(), -8, ResUtils.getString(this.mContext, "ebpay_no_network"));
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity) {
        String b2 = restResponseEntity.b("token");
        if (!TextUtils.isEmpty(b2)) {
            AccountManager.getInstance(this.mContext).setBfbToken(b2);
        }
        List<String> a2 = restResponseEntity.a("Set-Cookie");
        if (a2 != null) {
            for (int i = 0; i < a2.size(); i++) {
                String str = a2.get(i);
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

    public boolean isLbsPayBean() {
        return false;
    }

    public boolean isSign() {
        return false;
    }

    public abstract boolean needNonce();

    public boolean needVerifySignature() {
        return false;
    }
}
