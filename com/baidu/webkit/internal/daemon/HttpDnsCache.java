package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class HttpDnsCache implements INoProGuard, INetListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BACKUP_IP = "{\"area\": \"idc.ct\",   \"backup\": {    \"m.baidu.com\": {      \"ip\": [        \"220.181.38.130\",       \"220.181.38.129\"        ]    },    \"mbd.baidu.com\": {      \"ip\": [       \"180.149.145.177\",         \"112.34.111.104\",        \"111.206.37.66\",        \"180.97.104.214\",        \"117.185.17.20\",        \"112.80.248.204\",       \"14.215.177.166\",        \"183.232.231.184\",        \"163.177.151.106\"       ]    }  },   \"msg\": \"ok\",   \"ttl\": 300,  \"version\": \"v.01\"}";
    public static final String LOG_TAG = "HttpDnsCache";
    public static final String SERVER_LABEL = "?label=browser&type=ipv4&group=ipv6_11_16";
    public static final String SERVER_LABEL_V1 = "?label=browser&type=ipv4,ipv6&group=ipv6_11_23";
    public static final String SERVER_STATIC_URL = "https://httpsdns.baidu.com/v6/0010/";
    public static final String SERVER_URL = "https://180.76.76.112/v6/0010/";
    public static String mBackupIpVersion = "v.00";
    public static boolean mRestore;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteArrayOutputStream mData;
    public String mIpv4Data;
    public String mIpv6Data;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(209457474, "Lcom/baidu/webkit/internal/daemon/HttpDnsCache;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(209457474, "Lcom/baidu/webkit/internal/daemon/HttpDnsCache;");
        }
    }

    public HttpDnsCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mData = null;
    }

    private void addRawLogItem(StringBuilder sb, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{sb, str, Long.valueOf(j)}) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(j);
        }
    }

    private void addRawLogItem(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, sb, str, str2) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(str2);
        }
    }

    private void addRawLogItem(StringBuilder sb, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, sb, str, z) == null) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(z);
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getHttpdnsLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (WebSettingsGlobalBlink.getIpv6HttpdnsEnv()) {
                Log.w(LOG_TAG, "SERVER_LABEL_V1");
                return SERVER_LABEL_V1;
            }
            Log.w(LOG_TAG, "SERVER_LABEL");
            return SERVER_LABEL;
        }
        return (String) invokeV.objValue;
    }

    public static String getUrl(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String httpDnsUrlIP = WebSettingsGlobalBlink.getHttpDnsUrlIP();
            if (httpDnsUrlIP != null) {
                str = httpDnsUrlIP + getHttpdnsLabel();
                str2 = "urlNative!=null: ".concat(String.valueOf(httpDnsUrlIP));
            } else {
                str = SERVER_URL + getHttpdnsLabel();
                str2 = "urlNative==null ";
            }
            Log.w(LOG_TAG, str2);
            if (!TextUtils.isEmpty(mBackupIpVersion)) {
                str = (str + "&backup=") + mBackupIpVersion;
            }
            Log.d("cronet", "http_dns cloud url ".concat(String.valueOf(str)));
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getUrlStaticIP() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String httpDnsUrlHOST = WebSettingsGlobalBlink.getHttpDnsUrlHOST();
            if (httpDnsUrlHOST != null) {
                str = httpDnsUrlHOST + getHttpdnsLabel();
                str2 = "urlNative!=null: ".concat(String.valueOf(httpDnsUrlHOST));
            } else {
                str = SERVER_STATIC_URL + getHttpdnsLabel();
                str2 = "urlNative==null ";
            }
            Log.w(LOG_TAG, str2);
            if (!TextUtils.isEmpty(mBackupIpVersion)) {
                str = (str + "&backup=") + mBackupIpVersion;
            }
            Log.d("cronet", "http_dns cloud url static ip ".concat(String.valueOf(str)));
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static void restoreLastCacheFromCfg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            if (WebSettingsGlobalBlink.GetCloudSettingsValue("http_dns_persist_v1") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("http_dns_persist_v1").equals("false")) {
                Log.i(LOG_TAG, "restoreLastCacheFromCfg http_dns_persist false");
                return;
            }
            try {
                if (mRestore) {
                    return;
                }
                mRestore = true;
                Log.w(LOG_TAG, "restoreLastCacheFromCfg ok  ");
                String str = CfgFileUtils.get(CfgFileUtils.KEY_HTTP_DNS_CACHE, (String) null);
                if (str != null) {
                    WebSettingsGlobalBlink.setHttpDnsCache(str, 1);
                } else {
                    WebSettingsGlobalBlink.setHttpDnsCache(BACKUP_IP, 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void saveLastCacheToCfg(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, str) == null) || str == null) {
            return;
        }
        try {
            CfgFileUtils.set(CfgFileUtils.KEY_HTTP_DNS_CACHE, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String transHttpsUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            boolean z = true;
            try {
                if (WebSettingsGlobalBlink.GetCloudSettingsValue("https_dns") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("https_dns").equals("false")) {
                    z = false;
                }
                return z ? (str == null || !str.startsWith("https://")) ? str.replace("http://", "https://") : str : (str == null || !str.startsWith("http://")) ? str.replace("https://", "http://") : str;
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void tryToUpdateHttpDnsCache(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            if (WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE) != null && WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE).equals("false")) {
                str = "tryToUpdateHttpDnsCache http_dns false";
            } else if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                str = "tryToUpdateHttpDnsCache festival return";
            } else {
                Log.i(LOG_TAG, "tryToUpdateHttpDnsCache");
                restoreLastCacheFromCfg();
                if (WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns") == null || !WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns").equals("true")) {
                    try {
                        BdNet bdNet = new BdNet(context);
                        bdNet.setEventListener(new HttpDnsCache());
                        BdNetTask bdNetTask = new BdNetTask();
                        bdNetTask.setNet(bdNet);
                        bdNetTask.setUrl(getUrl(context));
                        bdNet.start(bdNetTask, true);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                str = "block_http_dns1";
            }
            Log.i(LOG_TAG, str);
        }
    }

    public static void tryToUpdateHttpDnsCacheStaticIP(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            if (WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE) != null && WebSettingsGlobalBlink.GetCloudSettingsValue(ETAG.KEY_HTTP_DNS_ENABLE).equals("false")) {
                str = "tryToUpdateHttpDnsCacheStaticIP http_dns false";
            } else if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                str = "tryToUpdateHttpDnsCacheStaticIP festival return";
            } else {
                restoreLastCacheFromCfg();
                Log.i(LOG_TAG, "tryToUpdateHttpDnsCacheStaticIP");
                if (WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns") == null || !WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns").equals("true")) {
                    try {
                        BdNet bdNet = new BdNet(context);
                        bdNet.setEventListener(new HttpDnsCache());
                        BdNetTask bdNetTask = new BdNetTask();
                        bdNetTask.setNet(bdNet);
                        bdNetTask.setUrl(getUrlStaticIP());
                        bdNet.start(bdNetTask, true);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                str = "block_http_dns2";
            }
            Log.i(LOG_TAG, str);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdNet) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdNet, bdNetTask, netError, i) == null) {
            Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, bdNet, bdNetTask, bArr, i) == null) {
            if (this.mData == null) {
                this.mData = new ByteArrayOutputStream();
            }
            this.mData.write(bArr, 0, i);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, bdNet, bdNetTask, i)) == null) {
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, bdNet, bdNetTask, i) == null) {
            Log.w(LOG_TAG, "onNetResponseCode  " + i + " url " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, bdNet, bdNetTask, netState, i) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bdNet, bdNetTask) == null) {
            ByteArrayOutputStream byteArrayOutputStream = this.mData;
            if (byteArrayOutputStream == null) {
                Log.w(LOG_TAG, "mData==null");
                return;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
            Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
            try {
                String str = new String(byteArray, IMAudioTransRequest.CHARSET);
                if (!TextUtils.isEmpty(str)) {
                    WebSettingsGlobalBlink.setHttpDnsCache(str, 2);
                }
                String httpDnsCache = WebSettingsGlobalBlink.getHttpDnsCache();
                if (TextUtils.isEmpty(httpDnsCache)) {
                    return;
                }
                Log.w(LOG_TAG, "saveLastCacheToCfg ".concat(String.valueOf(httpDnsCache)));
                saveLastCacheToCfg(httpDnsCache);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask) == null) {
            Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048586, this, bdNet, bdNetTask, i, i2) == null) {
        }
    }
}
