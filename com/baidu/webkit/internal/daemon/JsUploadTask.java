package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.CloudSettings;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class JsUploadTask implements INoProGuard {
    private static final int CONN_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 10000;
    private static final String TAG = "JsInterface";
    private static String mAppVersion;
    private static String mAppid;
    private static String mBTranUrl;
    private static int mBlockedAdCount;
    private static String mCpuType;
    private static boolean mCssLoaded;
    private static String mCurrentUrl;
    private static int mDocumentLoadState;
    private static int mErrorCode;
    private static boolean mErrorUploadAlreadySet;
    private static boolean mErrorUploadEnabled;
    private static long mFirstScreenTime;
    private static String mGpuType;
    private static boolean mHttpDnsEnable;
    private static boolean mMainLinkDirectAlreadySet;
    private static int mNetError;
    private static String mNetType;
    private static boolean mOnePacketAlreadySet;
    private static String mPacUrl;
    private static long mPageFinishedTime;
    private static long mPageStartTime;
    private static int mParsedTokens;
    private static boolean mPreloadAlreadySet;
    private static int mReceivedDataSize;
    private static String mSdkVer;
    private static String mSearchId;
    private static boolean mSessionHeaderAlreadySet;
    private static boolean mSpdyAlreadySet;
    private static boolean mSpdyCompressAlreadySet;
    private static boolean mSpdyEncryptionAlreadySet;
    private static String mStatisticsSessionId;
    private static String mTimeStamp;
    private static int mUpLoadNum;
    private static boolean mUsingCloudSettingsAlreadySet;
    private static boolean mWebessenseAlreadySet;
    private static String mXFirstJumpUrl;
    private static String mZeusVer;
    private Context mContext;
    private String mReferer;
    private String mTag;
    private String mUrl;
    private String mXReferer;
    private boolean responded;
    private static String mCuid = "0";
    private static int mCurEngine = -1;
    private static boolean mUsingCloudSettings = true;
    private static boolean mIsMobileSite = true;
    private static int mHttpcode = -1;
    private static int mNetcode = AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL;
    private static int mWiseLandingPageType = AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL;
    private static JumpType mFirstJumpType = JumpType.DefaultJump;
    private static JumpType mLastJumpType = JumpType.DefaultJump;

    /* loaded from: classes14.dex */
    public enum JumpType {
        DefaultJump,
        JsJump,
        RedirectJump,
        TCRedirectJump,
        LPRedirectJump
    }

    public JsUploadTask() {
    }

    public JsUploadTask(Context context, String str, String str2, String str3, String str4) {
        this.mReferer = str3;
        this.mUrl = str;
        this.mContext = context;
        this.mTag = str2;
        this.mXReferer = str4;
    }

    private static void addExternalItem(StringBuilder sb) {
        HashMap<String, String> statisticParams = WebKitFactory.getStatisticParams();
        if (statisticParams == null || statisticParams.isEmpty()) {
            return;
        }
        for (String str : statisticParams.keySet()) {
            if (sb.length() > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(str);
            sb.append("=");
            sb.append(statisticParams.get(str));
        }
    }

    private static void addRawLogItem(StringBuilder sb, String str, long j) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append("=");
        sb.append(j);
    }

    private static void addRawLogItem(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
    }

    private static void addRawLogItem(StringBuilder sb, String str, boolean z) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str);
        sb.append("=");
        sb.append(z);
    }

    public static void addUploadNum() {
        mUpLoadNum++;
    }

    public static synchronized String getEngineInfo() {
        String sb;
        boolean z = false;
        synchronized (JsUploadTask.class) {
            StringBuilder sb2 = new StringBuilder();
            if (mCurrentUrl != null) {
                z = WebSettingsGlobalBlink.shouldAccessNetworkOverSpdy(mCurrentUrl);
                Log.w(TAG, "getEngineInfo " + mCurrentUrl + " spdy " + z);
            } else if (WebKitFactory.getCurEngine() == 1) {
                z = WebSettingsGlobalBlink.getEnableSpdy();
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
            addRawLogItem(sb2, ETAG.KEY_TIME_STAMP, mTimeStamp);
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
            addRawLogItem(sb2, "net_error", mNetError);
            addRawLogItem(sb2, "http_code", mHttpcode);
            addRawLogItem(sb2, ETAG.KEY_NET_CODE, mNetcode);
            addRawLogItem(sb2, ETAG.KEY_FIRST_JUMP_TYPE, mFirstJumpType.ordinal());
            addRawLogItem(sb2, ETAG.KEY_LAST_JUMP_TYPE, mLastJumpType.ordinal());
            addRawLogItem(sb2, ETAG.KEY_BLOCKED_AD_COUNT, mBlockedAdCount);
            addRawLogItem(sb2, ETAG.KEY_WORMHOLE_ENABLE, WebSettingsGlobalBlink.getWormholeEnabled());
            addRawLogItem(sb2, ETAG.KEY_SUB_RESOURCE_ENABLE, WebSettingsGlobalBlink.getSubResourceMonitorEnabled());
            mNetError = 0;
            mHttpcode = -1;
            mNetcode = AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL;
            mFirstJumpType = JumpType.DefaultJump;
            mLastJumpType = JumpType.DefaultJump;
            if (WebKitFactory.getCurEngine() == 1) {
                addRawLogItem(sb2, ETAG.KEY_SPDY, z);
                addRawLogItem(sb2, ETAG.KEY_SPDY31, spdy31Enabled);
                addRawLogItem(sb2, ETAG.KEY_HTTP2_WORMHOLE, http2Enabled);
                Log.w(TAG, "[mohao] HTTP2_WORMHOLE: " + http2Enabled);
                addRawLogItem(sb2, ETAG.KEY_ZEUS_VER, mZeusVer);
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
                if (z) {
                    addRawLogItem(sb2, ETAG.KEY_SPDY_COMPRESS, WebSettingsGlobalBlink.getSpdyCompressEnabled());
                    addRawLogItem(sb2, ETAG.KEY_SPDY_HOST, WebSettingsGlobalBlink.getCloudHost());
                    addRawLogItem(sb2, ETAG.KEY_QUIC_HOST, WebSettingsGlobalBlink.getQuicHost());
                }
                addRawLogItem(sb2, ETAG.KEY_QUIC_THRESHOLD, WebSettingsGlobalBlink.getQuicThreshold());
                mHttpDnsEnable = WebSettingsGlobalBlink.GetHttpDnsCache(mCurrentUrl);
                addRawLogItem(sb2, ETAG.KEY_HTTP_DNS_ENABLE, mHttpDnsEnable);
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
                        jSONObject.put(ETAG.KEY_CRONET_ENABLE, aVar.c);
                        jSONObject.put(ETAG.KEY_CRONET_NET_TIME, aVar.f3832a);
                        jSONObject.put(ETAG.KEY_CRONET_NET_RES, aVar.b);
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
                    Log.w(TAG, "[mohao] extension: " + jSONObject2);
                    addRawLogItem(sb2, ETAG.KEY_EXTENSION, jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static synchronized String getEngineInfoInternal() {
        boolean shouldAccessNetworkOverSpdy;
        String sb;
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
            addRawLogItem(sb2, ETAG.KEY_TIME_STAMP, mTimeStamp);
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

    public static String getFirstJumpUrl() {
        return mXFirstJumpUrl;
    }

    public static String getNetType() {
        return mNetType;
    }

    public static boolean getSpdyAlreadySet() {
        return mSpdyAlreadySet;
    }

    public static boolean getUsingCloudSettings() {
        return mUsingCloudSettings;
    }

    public static void setAlreadySetEnabled(boolean z) {
        mUsingCloudSettingsAlreadySet = z;
        mSpdyAlreadySet = z;
        mMainLinkDirectAlreadySet = z;
        mWebessenseAlreadySet = z;
        mSessionHeaderAlreadySet = z;
        mOnePacketAlreadySet = z;
        mSpdyEncryptionAlreadySet = z;
    }

    public static void setAppVersion(String str) {
        if (str == null || str.equals(mAppVersion)) {
            return;
        }
        mAppVersion = str;
    }

    public static void setAppid(String str) {
        if (str == null || str.equals(mAppid)) {
            return;
        }
        mAppid = str;
    }

    public static void setBlockedAdCount(int i) {
        mBlockedAdCount = i;
    }

    public static void setCpuType(String str) {
        if (str == null || str.equals(mCpuType)) {
            return;
        }
        mCpuType = str;
    }

    public static void setCssLoaded(boolean z) {
        mCssLoaded = z;
    }

    public static void setCuid(String str) {
        if (str == null || str.equals(mCuid)) {
            return;
        }
        mCuid = str;
    }

    public static void setCurrentUrl(String str) {
        mCurrentUrl = str;
    }

    public static void setDocumentLoadState(int i) {
        mDocumentLoadState = i;
    }

    public static void setErrorCode(int i) {
        mErrorCode = i;
    }

    public static void setErrorUploadEnabled(boolean z) {
        if (mUsingCloudSettings && !mErrorUploadAlreadySet) {
            mErrorUploadAlreadySet = true;
            mErrorUploadEnabled = z;
        }
    }

    public static void setFirstJumpType(JumpType jumpType) {
        if (mFirstJumpType == JumpType.DefaultJump) {
            mFirstJumpType = jumpType;
        }
    }

    public static void setFirstJumpUrl(String str) {
        if (mXFirstJumpUrl == null) {
            mXFirstJumpUrl = str;
        }
    }

    public static void setGpuType(String str) {
        if (str == null || str.equals(mGpuType)) {
            return;
        }
        mGpuType = str;
    }

    public static void setHttpDns(boolean z) {
        mHttpDnsEnable = z;
    }

    public static void setIsMobileSite(boolean z) {
        mIsMobileSite = z;
    }

    public static void setLastJumpType(JumpType jumpType) {
        mLastJumpType = jumpType;
    }

    public static void setMainLinkDirectEnabled(boolean z) {
        if (mUsingCloudSettings && !mMainLinkDirectAlreadySet) {
            mMainLinkDirectAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setMainLinkDirectEnabled(z);
            }
        }
    }

    public static void setNetError(int i) {
        mNetError = i;
    }

    public static void setNetType(String str) {
        if (str == null || str.equals(mNetType)) {
            return;
        }
        mNetType = str;
    }

    public static void setOnePacketEnabled(boolean z) {
        if (mUsingCloudSettings && !mOnePacketAlreadySet) {
            mOnePacketAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setOnePacketEnabled(z);
            }
        }
    }

    public static void setPageFinishedTime(long j) {
        mPageFinishedTime = j;
    }

    public static void setParsedTokens(int i) {
        mParsedTokens = i;
    }

    public static void setPreloadEnabled(boolean z) {
        if (mUsingCloudSettings && !mPreloadAlreadySet) {
            mPreloadAlreadySet = true;
        }
    }

    public static void setReceivedDataSize(int i) {
        mReceivedDataSize = i;
    }

    public static void setSdkVer(String str) {
        if (str == null || str.equals(mSdkVer)) {
            return;
        }
        mSdkVer = str;
    }

    public static void setSessionHeaderEnabled(boolean z) {
        if (mUsingCloudSettings && !mSessionHeaderAlreadySet) {
            mSessionHeaderAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setSessionHeaderEnabled(z);
            }
        }
    }

    public static void setSpdyCompressEnabled(boolean z) {
        if (mUsingCloudSettings && !mSpdyCompressAlreadySet) {
            mSpdyCompressAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setSpdyCompressEnabled(z);
            }
        }
    }

    public static void setSpdyEnabled(boolean z) {
        if (mUsingCloudSettings && !mSpdyAlreadySet) {
            mSpdyAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setEnableSpdy(z);
            }
        }
    }

    public static void setSpdyEncryptionEnabled(boolean z) {
        if (mUsingCloudSettings && !mSpdyEncryptionAlreadySet) {
            mSpdyEncryptionAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setSpdyEncryptionEnabled(z);
            }
        }
    }

    public static void setStatisticsSessionId(String str) {
        if (str == null || str.equals(mStatisticsSessionId)) {
            return;
        }
        mStatisticsSessionId = str;
    }

    public static void setTimeStamp(String str) {
        mTimeStamp = str;
    }

    public static void setUsingCloudSettingsEnabled(boolean z) {
        if (mUsingCloudSettingsAlreadySet) {
            return;
        }
        mUsingCloudSettingsAlreadySet = true;
        mUsingCloudSettings = z;
    }

    public static void setWebessenseEnabled(boolean z) {
        if (mUsingCloudSettings && !mWebessenseAlreadySet) {
            mWebessenseAlreadySet = true;
            if (WebKitFactory.getCurEngine() == 1) {
                WebSettingsGlobalBlink.setWebessenseEnabled(z);
            }
        }
    }

    public static void setZeusVer(String str) {
        if (str == null || str.equals(mZeusVer)) {
            return;
        }
        mZeusVer = str;
    }

    public void setBTransUrl(String str) {
        mBTranUrl = str;
    }

    public void setEngine(int i) {
        if (mCurEngine != i) {
            mCurEngine = i;
        }
    }

    public void setFirstScreenTime(long j) {
        mFirstScreenTime = j;
    }

    public void setHttpcode(int i) {
        if (mHttpcode != i) {
            mHttpcode = i;
        }
    }

    public void setNetcode(int i) {
        if (mNetcode != i) {
            mNetcode = i;
        }
    }

    public void setPageStartTime(long j) {
        mPageStartTime = j;
    }

    public void setSearchId(String str) {
        mSearchId = str;
    }

    public void setWiseLandingPageType(int i) {
        if (mWiseLandingPageType != i) {
            mWiseLandingPageType = i;
        }
    }
}
