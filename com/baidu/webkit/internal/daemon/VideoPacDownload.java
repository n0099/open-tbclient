package com.baidu.webkit.internal.daemon;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.blink.VideoFreeFlowConfigManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.resource.IResourceTask;
import com.baidu.webkit.internal.resource.ResourceSchedulerEngine;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidubce.http.Headers;
import java.io.ByteArrayOutputStream;
import java.util.Map;
/* loaded from: classes6.dex */
public class VideoPacDownload implements IResourceTask, INetListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "VideoPacDownload";
    public static final String PMS_PACKAGE_NAME = "com.baidu.zeus.videopacdownload";
    public static boolean mDownloading;
    public static WebSettings.ProxyType mPacType;
    public static boolean mSuccessDownload;
    public static String sPacUrl;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteArrayOutputStream mData;
    public Map<String, String> mHeader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1078739396, "Lcom/baidu/webkit/internal/daemon/VideoPacDownload;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1078739396, "Lcom/baidu/webkit/internal/daemon/VideoPacDownload;");
                return;
            }
        }
        mPacType = WebSettings.ProxyType.NO_PROXY;
        sPacUrl = "https://browserkernel.baidu.com/newpac31/videoproxy.conf.txt";
    }

    public VideoPacDownload() {
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

    public static String getPacUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sPacUrl : (String) invokeV.objValue;
    }

    public static void restoreLastData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                String str = CfgFileUtils.get(CfgFileUtils.KEY_VIDEO_PROXY_DATA, (String) null);
                if (str == null) {
                    Log.w(LOG_TAG, "restoreLastData null");
                    return;
                }
                Log.w(LOG_TAG, "restoreLastData  ".concat(String.valueOf(str)));
                VideoFreeFlowConfigManager.getInstance().setPacData(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void tryToDownLoadAsync(Context context) {
        String pacUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (!WebKitFactory.getNeedDownloadCloudResource()) {
                Log.w(LOG_TAG, " tryToDownLoadAsync  return");
                restoreLastData();
                return;
            }
            restoreLastData();
            if (WebSettingsGlobalBlink.getProxyType() == WebSettings.ProxyType.NO_PROXY || mSuccessDownload || mDownloading || (pacUrl = getPacUrl()) == null || pacUrl.length() == 0) {
                return;
            }
            mDownloading = true;
            if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                Log.i(LOG_TAG, "tryToDownLoadAsync canceled by spring_festival_switch");
                VideoFreeFlowConfigManager.getInstance().initLocalRule();
                mSuccessDownload = true;
                mDownloading = false;
                return;
            }
            try {
                VideoPacDownload videoPacDownload = new VideoPacDownload();
                if (ResourceSchedulerEngine.getInstance().registTaskAndListener(videoPacDownload, null)) {
                    return;
                }
                BdNet bdNet = new BdNet(context);
                bdNet.setEventListener(videoPacDownload);
                BdNetTask bdNetTask = new BdNetTask();
                bdNetTask.setNet(bdNet);
                bdNetTask.setUrl(getPacUrl());
                bdNet.start(bdNetTask, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getCacheFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "videopacdownload.dat" : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public IResourceTask.OutputType getOutputType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? IResourceTask.OutputType.STRING : (IResourceTask.OutputType) invokeV.objValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getPMSPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PMS_PACKAGE_NAME : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getTaskName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "videopacdownload" : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getTaskUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getPacUrl() : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdNet) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048583, this, bdNet, bdNetTask, netError, i) == null) {
            mDownloading = false;
            Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask, bArr, i) == null) {
            if (this.mData == null) {
                this.mData = new ByteArrayOutputStream();
            }
            this.mData.write(bArr, 0, i);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdNet, bdNetTask) == null) {
            this.mHeader = bdNetTask.getResHeaders();
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, bdNet, bdNetTask, i)) == null) {
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, bdNet, bdNetTask, i) == null) {
            Log.w(LOG_TAG, "onNetResponseCode  " + i + " url " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048588, this, bdNet, bdNetTask, netState, i) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, bdNet, bdNetTask) == null) {
            mDownloading = false;
            if (this.mData != null) {
                Map<String, String> map = this.mHeader;
                if (map != null) {
                    String str2 = map.get(Headers.LAST_MODIFIED);
                    Log.w(LOG_TAG, "lastModify ".concat(String.valueOf(str2)));
                    if (str2 != null) {
                        Log.w(LOG_TAG, "lastModify1 ".concat(String.valueOf(str2)));
                        CfgFileUtils.set(CfgFileUtils.KEY_VIDEO_PROXY_LASTMODIFY, str2);
                    }
                }
                byte[] byteArray = this.mData.toByteArray();
                Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
                mSuccessDownload = true;
                try {
                    String str3 = new String(byteArray, "UTF-8");
                    VideoFreeFlowConfigManager.getInstance().setPacData(str3);
                    CfgFileUtils.set(CfgFileUtils.KEY_VIDEO_PROXY_DATA, str3);
                    return;
                } catch (Exception e2) {
                    str = "mTimgConfData1 ".concat(String.valueOf(e2));
                }
            } else {
                str = "mData==null";
            }
            Log.w(LOG_TAG, str);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bdNet, bdNetTask) == null) {
            Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048592, this, bdNet, bdNetTask, i, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public void onResourceReady(String str, IResourceTask.ResultType resultType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, resultType) == null) {
            Log.w(LOG_TAG, "onResourceReady1 ".concat(String.valueOf(resultType)));
            if (str != null) {
                Log.w(LOG_TAG, "onResourceReady2 " + str.length());
                VideoFreeFlowConfigManager.getInstance().setPacData(str);
                CfgFileUtils.set(CfgFileUtils.KEY_VIDEO_PROXY_DATA, str);
            }
            ResourceSchedulerEngine.getInstance().unregistTaskAndListener(this);
        }
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public boolean shouldBeUnZip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public boolean shouldForceLoadFromFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
