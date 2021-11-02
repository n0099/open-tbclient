package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.CloudSettings;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class JsUploadTask implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONN_TIMEOUT = 5000;
    public static final int READ_TIMEOUT = 10000;
    public static final String TAG = "JsInterface";
    public static String mAppVersion = null;
    public static String mAppid = null;
    public static String mBTranUrl = null;
    public static int mBlockedAdCount = 0;
    public static String mCpuType = null;
    public static boolean mCssLoaded = false;
    public static String mCuid = "0";
    public static int mCurEngine = -1;
    public static String mCurrentUrl = null;
    public static int mDocumentLoadState = 0;
    public static int mErrorCode = 0;
    public static boolean mErrorUploadAlreadySet = false;
    public static boolean mErrorUploadEnabled = false;
    public static JumpType mFirstJumpType = null;
    public static long mFirstScreenTime = 0;
    public static String mGpuType = null;
    public static boolean mHttpDnsEnable = false;
    public static int mHttpcode = -1;
    public static boolean mIsMobileSite = true;
    public static JumpType mLastJumpType = null;
    public static boolean mMainLinkDirectAlreadySet = false;
    public static int mNetError = 0;
    public static String mNetType = null;
    public static int mNetcode = -500;
    public static boolean mOnePacketAlreadySet = false;
    public static String mPacUrl = null;
    public static long mPageFinishedTime = 0;
    public static long mPageStartTime = 0;
    public static int mParsedTokens = 0;
    public static boolean mPreloadAlreadySet = false;
    public static int mReceivedDataSize = 0;
    public static String mSdkVer = null;
    public static String mSearchId = null;
    public static boolean mSessionHeaderAlreadySet = false;
    public static boolean mSpdyAlreadySet = false;
    public static boolean mSpdyCompressAlreadySet = false;
    public static boolean mSpdyEncryptionAlreadySet = false;
    public static String mStatisticsSessionId = null;
    public static String mTimeStamp = null;
    public static int mUpLoadNum = 0;
    public static boolean mUsingCloudSettings = true;
    public static boolean mUsingCloudSettingsAlreadySet = false;
    public static boolean mWebessenseAlreadySet = false;
    public static int mWiseLandingPageType = -500;
    public static String mXFirstJumpUrl;
    public static String mZeusVer;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mReferer;
    public String mTag;
    public String mUrl;
    public String mXReferer;
    public boolean responded;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class JumpType {
        public static final /* synthetic */ JumpType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final JumpType DefaultJump;
        public static final JumpType JsJump;
        public static final JumpType LPRedirectJump;
        public static final JumpType RedirectJump;
        public static final JumpType TCRedirectJump;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-124262634, "Lcom/baidu/webkit/internal/daemon/JsUploadTask$JumpType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-124262634, "Lcom/baidu/webkit/internal/daemon/JsUploadTask$JumpType;");
                    return;
                }
            }
            DefaultJump = new JumpType("DefaultJump", 0);
            JsJump = new JumpType("JsJump", 1);
            RedirectJump = new JumpType("RedirectJump", 2);
            TCRedirectJump = new JumpType("TCRedirectJump", 3);
            JumpType jumpType = new JumpType("LPRedirectJump", 4);
            LPRedirectJump = jumpType;
            $VALUES = new JumpType[]{DefaultJump, JsJump, RedirectJump, TCRedirectJump, jumpType};
        }

        public JumpType(String str, int i2) {
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

        public static JumpType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (JumpType) Enum.valueOf(JumpType.class, str) : (JumpType) invokeL.objValue;
        }

        public static JumpType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (JumpType[]) $VALUES.clone() : (JumpType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-333895116, "Lcom/baidu/webkit/internal/daemon/JsUploadTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-333895116, "Lcom/baidu/webkit/internal/daemon/JsUploadTask;");
                return;
            }
        }
        JumpType jumpType = JumpType.DefaultJump;
        mFirstJumpType = jumpType;
        mLastJumpType = jumpType;
    }

    public JsUploadTask() {
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

    public JsUploadTask(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mReferer = str3;
        this.mUrl = str;
        this.mContext = context;
        this.mTag = str2;
        this.mXReferer = str4;
    }

    public static void addExternalItem(StringBuilder sb) {
        HashMap<String, String> statisticParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, sb) == null) || (statisticParams = WebKitFactory.getStatisticParams()) == null || statisticParams.isEmpty()) {
            return;
        }
        for (String str : statisticParams.keySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(statisticParams.get(str));
        }
    }

    public static void addRawLogItem(StringBuilder sb, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{sb, str, Long.valueOf(j)}) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(j);
        }
    }

    public static void addRawLogItem(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, sb, str, str2) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(str2);
        }
    }

    public static void addRawLogItem(StringBuilder sb, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, sb, str, z) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(z);
        }
    }

    public static void addUploadNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            mUpLoadNum++;
        }
    }

    public static synchronized String getEngineInfo() {
        InterceptResult invokeV;
        boolean shouldAccessNetworkOverSpdy;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (JsUploadTask.class) {
                StringBuilder sb2 = new StringBuilder();
                if (mCurrentUrl == null) {
                    shouldAccessNetworkOverSpdy = WebKitFactory.getCurEngine() == 1 ? WebSettingsGlobalBlink.getEnableSpdy() : false;
                } else {
                    shouldAccessNetworkOverSpdy = WebSettingsGlobalBlink.shouldAccessNetworkOverSpdy(mCurrentUrl);
                    Log.w(TAG, "getEngineInfo " + mCurrentUrl + " spdy " + shouldAccessNetworkOverSpdy);
                }
                boolean spdy31Enabled = WebSettingsGlobalBlink.getSpdy31Enabled();
                boolean http2Enabled = WebSettingsGlobalBlink.getHttp2Enabled();
                addRawLogItem(sb2, "appid", mAppid);
                addRawLogItem(sb2, "appversion", mAppVersion);
                addRawLogItem(sb2, "cuid", mCuid);
                addRawLogItem(sb2, "session_id", mStatisticsSessionId);
                addRawLogItem(sb2, ETAG.KEY_SEARCH_ID, mSearchId);
                addRawLogItem(sb2, ETAG.KEY_B_TRAN_URL, mBTranUrl);
                addExternalItem(sb2);
                addRawLogItem(sb2, "time_stamp", mTimeStamp);
                addRawLogItem(sb2, ETAG.KEY_CPU_TYPE, mCpuType);
                if (WebKitFactory.getCurEngine() == 1) {
                    addRawLogItem(sb2, ETAG.KEY_GPU_TYPE, mGpuType);
                }
                addRawLogItem(sb2, "net_type", mNetType);
                addRawLogItem(sb2, ETAG.KEY_ZEUS_STATE, WebKitFactory.getCurEngine());
                addRawLogItem(sb2, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
                if (WebKitFactory.getCurEngine() == 1) {
                    addRawLogItem(sb2, ETAG.KEY_BROWSER_VERSION, WebSettingsGlobalBlink.getBrowserVersion());
                }
                addRawLogItem(sb2, "model", Build.MODEL);
                addRawLogItem(sb2, "sdk_ver", WebKitFactory.getSdkVersionName());
                addRawLogItem(sb2, ETAG.KEY_PAGE_START, mPageStartTime);
                addRawLogItem(sb2, ETAG.KEY_PAGE_FINISHED, mPageFinishedTime);
                addRawLogItem(sb2, ETAG.KEY_UPLOAD_NUM, mUpLoadNum);
                addRawLogItem(sb2, ETAG.KEY_SYS_PROXY, WebSettingsGlobalBlink.getSysProxyEnabled());
                addRawLogItem(sb2, ETAG.KEY_NET_ERROR, mNetError);
                addRawLogItem(sb2, ETAG.KEY_HTTP_CODE, mHttpcode);
                addRawLogItem(sb2, ETAG.KEY_NET_CODE, mNetcode);
                addRawLogItem(sb2, ETAG.KEY_FIRST_JUMP_TYPE, mFirstJumpType.ordinal());
                addRawLogItem(sb2, ETAG.KEY_LAST_JUMP_TYPE, mLastJumpType.ordinal());
                addRawLogItem(sb2, ETAG.KEY_BLOCKED_AD_COUNT, mBlockedAdCount);
                addRawLogItem(sb2, ETAG.KEY_WORMHOLE_ENABLE, WebSettingsGlobalBlink.getWormholeEnabled());
                addRawLogItem(sb2, ETAG.KEY_SUB_RESOURCE_ENABLE, WebSettingsGlobalBlink.getSubResourceMonitorEnabled());
                mNetError = 0;
                mHttpcode = -1;
                mNetcode = -500;
                mFirstJumpType = JumpType.DefaultJump;
                mLastJumpType = JumpType.DefaultJump;
                if (WebKitFactory.getCurEngine() == 1) {
                    addRawLogItem(sb2, ETAG.KEY_SPDY, shouldAccessNetworkOverSpdy);
                    addRawLogItem(sb2, ETAG.KEY_SPDY31, spdy31Enabled);
                    addRawLogItem(sb2, ETAG.KEY_HTTP2_WORMHOLE, http2Enabled);
                    Log.w(TAG, "[mohao] HTTP2_WORMHOLE: ".concat(String.valueOf(http2Enabled)));
                    addRawLogItem(sb2, "zeus_ver", mZeusVer);
                    addRawLogItem(sb2, ETAG.KEY_FIRST_SCREEN, mFirstScreenTime);
                    addRawLogItem(sb2, ETAG.KEY_IS_MOBILE_SITE, mIsMobileSite);
                    String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("spdyswitch");
                    if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("auto_open")) {
                        addRawLogItem(sb2, ETAG.KEY_NETWORK_SPEED, 0L);
                    } else {
                        addRawLogItem(sb2, ETAG.KEY_NETWORK_SPEED, WebSettingsGlobalBlink.getNetworkSpeed());
                    }
                    addRawLogItem(sb2, ETAG.KEY_NETWORK_RTT, WebSettingsGlobalBlink.getNetworkRtt());
                    addRawLogItem(sb2, ETAG.KEY_LOCAL_DNS, WebSettingsGlobalBlink.getLocalDns());
                    addRawLogItem(sb2, ETAG.KEY_UP_TRAFFIC, WebSettingsGlobalBlink.getUpTraffic());
                    addRawLogItem(sb2, ETAG.KEY_DOWN_TRAFFIC, WebSettingsGlobalBlink.getDownTraffic());
                    if (shouldAccessNetworkOverSpdy) {
                        addRawLogItem(sb2, ETAG.KEY_SPDY_COMPRESS, WebSettingsGlobalBlink.getSpdyCompressEnabled());
                        addRawLogItem(sb2, ETAG.KEY_SPDY_HOST, WebSettingsGlobalBlink.getCloudHost());
                        addRawLogItem(sb2, ETAG.KEY_QUIC_HOST, WebSettingsGlobalBlink.getQuicHost());
                    }
                    addRawLogItem(sb2, ETAG.KEY_QUIC_THRESHOLD, WebSettingsGlobalBlink.getQuicThreshold());
                    boolean GetHttpDnsCache = WebSettingsGlobalBlink.GetHttpDnsCache(mCurrentUrl);
                    mHttpDnsEnable = GetHttpDnsCache;
                    addRawLogItem(sb2, ETAG.KEY_HTTP_DNS_ENABLE, GetHttpDnsCache);
                    String dnsInfo = WebSettingsGlobalBlink.getDnsInfo(mCurrentUrl);
                    Log.w(TAG, "[cronet] HTTP_DNS_ENABLE: " + mHttpDnsEnable + " http_dns info:" + dnsInfo + " url : " + mCurrentUrl);
                    addRawLogItem(sb2, ETAG.KEY_DNS_INFO, dnsInfo);
                    WebSettingsGlobalBlink.removeDnsInfo(mCurrentUrl);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        String GetCloudSettingsValue2 = WebSettingsGlobalBlink.GetCloudSettingsValue("page_feature_switch");
                        if (GetCloudSettingsValue2 == null || GetCloudSettingsValue2.equals("true")) {
                            String pageFeature = WebSettingsGlobalBlink.getPageFeature("HasOpacity");
                            String str = pageFeature.length() > 0 ? new String(Base64.encode(pageFeature.getBytes(), 0)) : "";
                            String pageFeature2 = WebSettingsGlobalBlink.getPageFeature("NoneDisplay");
                            String str2 = pageFeature2.length() > 0 ? new String(Base64.encode(pageFeature2.getBytes(), 0)) : "";
                            jSONObject.put("HasOpacity", str.replace("=", ""));
                            jSONObject.put("NoneDisplay", str2.replace("=", ""));
                        }
                        jSONObject.put(ETAG.KEY_WORMHOLE_ENABLE, WebSettingsGlobalBlink.getWormholeEnabled());
                        Log.w(TAG, "NetRecordList size " + CloudSettings.NetRecordList.size());
                        if (CloudSettings.NetRecordList.size() > 0) {
                            CloudSettings.a aVar = CloudSettings.NetRecordList.get(0);
                            CloudSettings.NetRecordList.remove(0);
                            Log.w(TAG, "NetRecordList size1 " + CloudSettings.NetRecordList.size());
                            jSONObject.put(ETAG.KEY_CRONET_ENABLE, aVar.f60992c);
                            jSONObject.put(ETAG.KEY_CRONET_NET_TIME, aVar.f60990a);
                            jSONObject.put(ETAG.KEY_CRONET_NET_RES, aVar.f60991b);
                        }
                        if (WebSettingsGlobalBlink.isFeedProxyAdUrl(mCurrentUrl)) {
                            jSONObject.put(ETAG.KEY_FEED_PROXY_AD, 1);
                        } else if (WebSettingsGlobalBlink.isFeedNoProxyAdUrl(mCurrentUrl)) {
                            jSONObject.put(ETAG.KEY_FEED_PROXY_AD, 0);
                        }
                        jSONObject.put("documentLoadState", mDocumentLoadState);
                        jSONObject.put("WormholeNum", WebSettingsGlobalBlink.getWormholeNum(0));
                        jSONObject.put("WormholeFailNum", WebSettingsGlobalBlink.getWormholeNum(1));
                        jSONObject.put("WormholeForbidenNum", WebSettingsGlobalBlink.getWormholeNum(2));
                        jSONObject.put("WormholeForbidenHost", WebSettingsGlobalBlink.getWormholeForbidenHost());
                        jSONObject.put(ETAG.KEY_FREE_FLOW_ENABLE, WebSettingsGlobalBlink.canUseFreeFlow());
                        String jSONObject2 = jSONObject.toString();
                        Log.w(TAG, "[mohao] extension: ".concat(String.valueOf(jSONObject2)));
                        addRawLogItem(sb2, ETAG.KEY_EXTENSION, jSONObject2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public static synchronized String getEngineInfoInternal() {
        InterceptResult invokeV;
        boolean shouldAccessNetworkOverSpdy;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            synchronized (JsUploadTask.class) {
                StringBuilder sb2 = new StringBuilder();
                if (mCurrentUrl == null) {
                    shouldAccessNetworkOverSpdy = WebSettingsGlobalBlink.getEnableSpdy();
                } else {
                    shouldAccessNetworkOverSpdy = WebSettingsGlobalBlink.shouldAccessNetworkOverSpdy(mCurrentUrl);
                    Log.w(TAG, "getEngineInfoInternal " + mCurrentUrl + " spdy " + shouldAccessNetworkOverSpdy);
                }
                boolean spdy31Enabled = WebSettingsGlobalBlink.getSpdy31Enabled();
                addRawLogItem(sb2, "appid", mAppid);
                addRawLogItem(sb2, "appversion", mAppVersion);
                addRawLogItem(sb2, "cuid", mCuid);
                addRawLogItem(sb2, "session_id", mStatisticsSessionId);
                addRawLogItem(sb2, ETAG.KEY_SEARCH_ID, mSearchId);
                addRawLogItem(sb2, ETAG.KEY_B_TRAN_URL, mBTranUrl);
                addExternalItem(sb2);
                addRawLogItem(sb2, "time_stamp", mTimeStamp);
                addRawLogItem(sb2, ETAG.KEY_CPU_TYPE, mCpuType);
                addRawLogItem(sb2, "net_type", mNetType);
                addRawLogItem(sb2, ETAG.KEY_ZEUS_STATE, WebKitFactory.getCurEngine());
                addRawLogItem(sb2, ETAG.KEY_DEV_VER, Build.VERSION.SDK_INT);
                addRawLogItem(sb2, "model", Build.MODEL);
                addRawLogItem(sb2, "sdk_ver", WebKitFactory.getSdkVersionName());
                addRawLogItem(sb2, ETAG.KEY_PAGE_START, mPageStartTime);
                addRawLogItem(sb2, ETAG.KEY_PAGE_FINISHED, mPageFinishedTime);
                addRawLogItem(sb2, ETAG.KEY_UPLOAD_NUM, mUpLoadNum);
                addRawLogItem(sb2, ETAG.KEY_SYS_PROXY, WebSettingsGlobalBlink.getSysProxyEnabled());
                addRawLogItem(sb2, ETAG.KEY_PARSED_TOKENS, mParsedTokens);
                addRawLogItem(sb2, ETAG.KEY_RECEIVED_DATA, mReceivedDataSize);
                addRawLogItem(sb2, ETAG.KEY_FIRST_PAINT, false);
                addRawLogItem(sb2, ETAG.KEY_SPDY, shouldAccessNetworkOverSpdy);
                addRawLogItem(sb2, ETAG.KEY_SPDY31, spdy31Enabled);
                addRawLogItem(sb2, ETAG.KEY_HTTP_DNS_ENABLE, mHttpDnsEnable);
                addRawLogItem(sb2, ETAG.KEY_WISE_LANDING_TYPE, mWiseLandingPageType);
                String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("spdyswitch");
                if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("auto_open")) {
                    addRawLogItem(sb2, ETAG.KEY_NETWORK_SPEED, 0L);
                } else {
                    addRawLogItem(sb2, ETAG.KEY_NETWORK_SPEED, WebSettingsGlobalBlink.getNetworkSpeed());
                }
                addRawLogItem(sb2, ETAG.KEY_WORMHOLE_ENABLE, WebSettingsGlobalBlink.getWormholeEnabled());
                addRawLogItem(sb2, ETAG.KEY_FREE_FLOW_ENABLE, WebSettingsGlobalBlink.canUseFreeFlow());
                addRawLogItem(sb2, ETAG.KEY_NETWORK_RTT, WebSettingsGlobalBlink.getNetworkRtt());
                addRawLogItem(sb2, ETAG.KEY_FIRST_JUMP_TYPE, mFirstJumpType.ordinal());
                addRawLogItem(sb2, ETAG.KEY_LAST_JUMP_TYPE, mLastJumpType.ordinal());
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public static String getFirstJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? mXFirstJumpUrl : (String) invokeV.objValue;
    }

    public static String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? mNetType : (String) invokeV.objValue;
    }

    public static boolean getSpdyAlreadySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? mSpdyAlreadySet : invokeV.booleanValue;
    }

    public static boolean getUsingCloudSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? mUsingCloudSettings : invokeV.booleanValue;
    }

    public static void setAlreadySetEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            mUsingCloudSettingsAlreadySet = z;
            mSpdyAlreadySet = z;
            mMainLinkDirectAlreadySet = z;
            mWebessenseAlreadySet = z;
            mSessionHeaderAlreadySet = z;
            mOnePacketAlreadySet = z;
            mSpdyEncryptionAlreadySet = z;
        }
    }

    public static void setAppVersion(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, str) == null) || str == null || str.equals(mAppVersion)) {
            return;
        }
        mAppVersion = str;
    }

    public static void setAppid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, str) == null) || str == null || str.equals(mAppid)) {
            return;
        }
        mAppid = str;
    }

    public static void setBlockedAdCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, null, i2) == null) {
            mBlockedAdCount = i2;
        }
    }

    public static void setCpuType(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, str) == null) || str == null || str.equals(mCpuType)) {
            return;
        }
        mCpuType = str;
    }

    public static void setCssLoaded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            mCssLoaded = z;
        }
    }

    public static void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, str) == null) || str == null || str.equals(mCuid)) {
            return;
        }
        mCuid = str;
    }

    public static void setCurrentUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            mCurrentUrl = str;
        }
    }

    public static void setDocumentLoadState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, null, i2) == null) {
            mDocumentLoadState = i2;
        }
    }

    public static void setErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, null, i2) == null) {
            mErrorCode = i2;
        }
    }

    public static void setErrorUploadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65560, null, z) == null) && mUsingCloudSettings && !mErrorUploadAlreadySet) {
            mErrorUploadAlreadySet = true;
            mErrorUploadEnabled = z;
        }
    }

    public static void setFirstJumpType(JumpType jumpType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, null, jumpType) == null) && mFirstJumpType == JumpType.DefaultJump) {
            mFirstJumpType = jumpType;
        }
    }

    public static void setFirstJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, null, str) == null) && mXFirstJumpUrl == null) {
            mXFirstJumpUrl = str;
        }
    }

    public static void setGpuType(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, null, str) == null) || str == null || str.equals(mGpuType)) {
            return;
        }
        mGpuType = str;
    }

    public static void setHttpDns(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65564, null, z) == null) {
            mHttpDnsEnable = z;
        }
    }

    public static void setIsMobileSite(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65565, null, z) == null) {
            mIsMobileSite = z;
        }
    }

    public static void setLastJumpType(JumpType jumpType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, jumpType) == null) {
            mLastJumpType = jumpType;
        }
    }

    public static void setMainLinkDirectEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65567, null, z) == null) && mUsingCloudSettings && !mMainLinkDirectAlreadySet) {
            mMainLinkDirectAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setMainLinkDirectEnabled(z);
            }
        }
    }

    public static void setNetError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65568, null, i2) == null) {
            mNetError = i2;
        }
    }

    public static void setNetType(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, null, str) == null) || str == null || str.equals(mNetType)) {
            return;
        }
        mNetType = str;
    }

    public static void setOnePacketEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65570, null, z) == null) && mUsingCloudSettings && !mOnePacketAlreadySet) {
            mOnePacketAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setOnePacketEnabled(z);
            }
        }
    }

    public static void setPageFinishedTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65571, null, j) == null) {
            mPageFinishedTime = j;
        }
    }

    public static void setParsedTokens(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65572, null, i2) == null) {
            mParsedTokens = i2;
        }
    }

    public static void setPreloadEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65573, null, z) == null) && mUsingCloudSettings && !mPreloadAlreadySet) {
            mPreloadAlreadySet = true;
        }
    }

    public static void setReceivedDataSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65574, null, i2) == null) {
            mReceivedDataSize = i2;
        }
    }

    public static void setSdkVer(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65575, null, str) == null) || str == null || str.equals(mSdkVer)) {
            return;
        }
        mSdkVer = str;
    }

    public static void setSessionHeaderEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65576, null, z) == null) && mUsingCloudSettings && !mSessionHeaderAlreadySet) {
            mSessionHeaderAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setSessionHeaderEnabled(z);
            }
        }
    }

    public static void setSpdyCompressEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65577, null, z) == null) && mUsingCloudSettings && !mSpdyCompressAlreadySet) {
            mSpdyCompressAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setSpdyCompressEnabled(z);
            }
        }
    }

    public static void setSpdyEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65578, null, z) == null) && mUsingCloudSettings && !mSpdyAlreadySet) {
            mSpdyAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setEnableSpdy(z);
            }
        }
    }

    public static void setSpdyEncryptionEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65579, null, z) == null) && mUsingCloudSettings && !mSpdyEncryptionAlreadySet) {
            mSpdyEncryptionAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setSpdyEncryptionEnabled(z);
            }
        }
    }

    public static void setStatisticsSessionId(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65580, null, str) == null) || str == null || str.equals(mStatisticsSessionId)) {
            return;
        }
        mStatisticsSessionId = str;
    }

    public static void setTimeStamp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, str) == null) {
            mTimeStamp = str;
        }
    }

    public static void setUsingCloudSettingsEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65582, null, z) == null) || mUsingCloudSettingsAlreadySet) {
            return;
        }
        mUsingCloudSettingsAlreadySet = true;
        mUsingCloudSettings = z;
    }

    public static void setWebessenseEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65583, null, z) == null) && mUsingCloudSettings && !mWebessenseAlreadySet) {
            mWebessenseAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setWebessenseEnabled(z);
            }
        }
    }

    public static void setZeusVer(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65584, null, str) == null) || str == null || str.equals(mZeusVer)) {
            return;
        }
        mZeusVer = str;
    }

    public void setBTransUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            mBTranUrl = str;
        }
    }

    public void setEngine(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || mCurEngine == i2) {
            return;
        }
        mCurEngine = i2;
    }

    public void setFirstScreenTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            mFirstScreenTime = j;
        }
    }

    public void setHttpcode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || mHttpcode == i2) {
            return;
        }
        mHttpcode = i2;
    }

    public void setNetcode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || mNetcode == i2) {
            return;
        }
        mNetcode = i2;
    }

    public void setPageStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            mPageStartTime = j;
        }
    }

    public void setSearchId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            mSearchId = str;
        }
    }

    public void setWiseLandingPageType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || mWiseLandingPageType == i2) {
            return;
        }
        mWiseLandingPageType = i2;
    }
}
