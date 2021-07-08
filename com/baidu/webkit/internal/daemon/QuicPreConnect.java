package com.baidu.webkit.internal.daemon;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public class QuicPreConnect implements INoProGuard, INetListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "QuicPreConnect";
    public static boolean mDownloading = false;
    public static final String mQuicPreConnectUrl = "https://m.baidu.com/static/searchbox/common/prelink.html?word=";
    public transient /* synthetic */ FieldHolder $fh;
    public ByteArrayOutputStream mData;

    public QuicPreConnect() {
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

    public static String getUrl(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String str = mQuicPreConnectUrl + System.currentTimeMillis();
            Log.w(LOG_TAG, "getUrl=".concat(String.valueOf(str)));
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void tryToQuicPreConnect(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                Log.i(LOG_TAG, "tryToQuicPreConnect spring_festival_switch return");
            } else if (!WebKitFactory.getNeedDownloadCloudResource()) {
                Log.i(LOG_TAG, "no need tryToQuicPreConnect");
            } else if (ConectivityUtils.getNetType(context).equals("unknown")) {
            } else {
                if (WebSettingsGlobalBlink.getPreconnectABTestEnable() && WebSettingsGlobalBlink.hasQuicAltService("https://m.baidu.com") && WebViewFactory.hasProvider() && WebViewFactory.getProvider().getStatics() != null) {
                    String str = mQuicPreConnectUrl + System.currentTimeMillis();
                    Log.i(LOG_TAG, "QuicPreconnect tryToQuicPreConnect preconnectUrl Url = ".concat(String.valueOf(str)));
                    WebViewFactory.getProvider().getStatics().preconnectUrl(str, 1);
                } else if (mDownloading) {
                } else {
                    mDownloading = true;
                    Log.i(LOG_TAG, "tryToQuicPreConnect prelink.html");
                    try {
                        BdNet bdNet = new BdNet(context);
                        bdNet.setEventListener(new QuicPreConnect());
                        BdNetTask bdNetTask = new BdNetTask();
                        bdNetTask.setNet(bdNet);
                        bdNetTask.setUrl(getUrl(context));
                        bdNet.start(bdNetTask, false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdNet) == null) {
            mDownloading = false;
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdNet, bdNetTask, netError, i2) == null) {
            mDownloading = false;
            Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, bdNet, bdNetTask, bArr, i2) == null) {
            if (this.mData == null) {
                this.mData = new ByteArrayOutputStream();
            }
            Log.w(LOG_TAG, "onNetReceiveData ".concat(String.valueOf(i2)));
            this.mData.write(bArr, 0, i2);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, bdNet, bdNetTask, i2)) == null) {
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, bdNet, bdNetTask, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, bdNet, bdNetTask, netState, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bdNet, bdNetTask) == null) {
            if (this.mData != null) {
                str = "onNetDownloadComplete url " + bdNetTask.getUrl();
            } else {
                str = "mData==null";
            }
            Log.w(LOG_TAG, str);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask) == null) {
            Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
            Log.w(LOG_TAG, "getUsingChromiumNet  " + bdNetTask.isUseCorenet());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048586, this, bdNet, bdNetTask, i2, i3) == null) {
        }
    }
}
