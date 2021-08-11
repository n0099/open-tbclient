package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
/* loaded from: classes9.dex */
public class HttpDnsCacheForHost implements INetListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JSON_KEY_DATA = "data";
    public static final String JSON_KEY_EXTINFO = "ext-info";
    public static final String JSON_KEY_IP = "ip";
    public static final String JSON_KEY_IPV6 = "ipv6";
    public static final String JSON_KEY_IPV6_GROUP = "ipv6-group";
    public static final String JSON_KEY_MSG = "msg";
    public static final String LOG_TAG = "HttpDnsCacheForHost";
    public static final String MSG_ERR = "error";
    public static final String SERVER_URL = "https://180.76.76.112/v6/0010";
    public static final String SERVER_URL_IPV6_ONLY = "https://[240c:4006::6666]/v6/0010";
    public static final String TARGET_EXTERNALHOST = "?dn=";
    public transient /* synthetic */ FieldHolder $fh;
    public ByteArrayOutputStream mData;
    public String mExternalHost;
    public boolean mIpv6Only;

    public HttpDnsCacheForHost() {
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
        this.mData = null;
    }

    public static String transHttpsUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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

    public static void tryToUpdateHttpDnsCacheHost(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, str, z) == null) || str == null) {
            return;
        }
        if (WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns") != null && WebSettingsGlobalBlink.GetCloudSettingsValue("block_http_dns").equals("true")) {
            Log.i(LOG_TAG, "block_http_dns3");
            return;
        }
        try {
            BdNet bdNet = new BdNet(WebKitFactory.getContext());
            HttpDnsCacheForHost httpDnsCacheForHost = new HttpDnsCacheForHost();
            httpDnsCacheForHost.setHttpDnsCacheHost(str);
            httpDnsCacheForHost.setHttpDnsIpv6Only(z);
            bdNet.setEventListener(httpDnsCacheForHost);
            BdNetTask bdNetTask = new BdNetTask();
            bdNetTask.setNet(bdNet);
            bdNetTask.setUrl(z ? httpDnsCacheForHost.getUrlIpv6Only(WebKitFactory.getContext()) : httpDnsCacheForHost.getUrl(WebKitFactory.getContext()));
            bdNet.start(bdNetTask, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String getUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            String httpDnsUrlIP = WebSettingsGlobalBlink.getHttpDnsUrlIP();
            if (httpDnsUrlIP != null) {
                Log.d(LOG_TAG, "urlNative!=null: ".concat(String.valueOf(httpDnsUrlIP)));
            } else {
                Log.d(LOG_TAG, "urlNative==null ");
                httpDnsUrlIP = "https://180.76.76.112/v6/0010";
            }
            if (this.mExternalHost != null) {
                httpDnsUrlIP = (httpDnsUrlIP + TARGET_EXTERNALHOST) + this.mExternalHost;
            }
            String transHttpsUrl = transHttpsUrl(httpDnsUrlIP);
            Log.d("cronet", "http_dns cloud url ".concat(String.valueOf(transHttpsUrl)));
            return transHttpsUrl;
        }
        return (String) invokeL.objValue;
    }

    public String getUrlIpv6Only(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            String transHttpsUrl = transHttpsUrl(((SERVER_URL_IPV6_ONLY + TARGET_EXTERNALHOST) + this.mExternalHost) + "&type=ipv6&group=ipv6");
            Log.d("cronet", "http_dns cloud url ipv6 ".concat(String.valueOf(transHttpsUrl)));
            return transHttpsUrl;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdNet) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, bdNet, bdNetTask, netError, i2) == null) {
            Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
            try {
                WebSettingsGlobalBlink.setHttpDnsDnFailed(this.mExternalHost);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, bdNet, bdNetTask, bArr, i2) == null) {
            if (this.mData == null) {
                this.mData = new ByteArrayOutputStream();
            }
            this.mData.write(bArr, 0, i2);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, bdNet, bdNetTask, i2)) == null) {
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, bdNet, bdNetTask, i2) == null) {
            Log.w(LOG_TAG, "onNetResponseCode  " + i2 + " url " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask, netState, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdNet, bdNetTask) == null) {
            ByteArrayOutputStream byteArrayOutputStream = this.mData;
            if (byteArrayOutputStream == null) {
                Log.w(LOG_TAG, "mData==null " + bdNetTask.getUrl());
                return;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
            Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
            try {
                String str = new String(byteArray, "utf-8");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                WebSettingsGlobalBlink.setHttpDnsCache(str, 3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bdNet, bdNetTask) == null) {
            Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048588, this, bdNet, bdNetTask, i2, i3) == null) {
        }
    }

    public void setHttpDnsCacheHost(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (str != null) {
                this.mExternalHost = str;
            } else {
                this.mExternalHost = null;
            }
        }
    }

    public void setHttpDnsIpv6Only(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mIpv6Only = z;
        }
    }
}
