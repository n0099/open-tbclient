package com.baidu.webkit.internal.daemon;

import android.content.Context;
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
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.resource.IResourceTask;
import com.baidu.webkit.internal.resource.ResourceSchedulerEngine;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.ByteArrayOutputStream;
import java.util.Map;
/* loaded from: classes11.dex */
public class PacDownload implements IResourceTask, INetListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "PacDownload";
    public static boolean mDownloading;
    public static boolean mPacFreeFlowSucced;
    public static boolean mPacSucced;
    public static WebSettings.ProxyType mPacType;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteArrayOutputStream mData;
    public boolean mFreeFlowEnabled;
    public Map<String, String> mHeader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1365573081, "Lcom/baidu/webkit/internal/daemon/PacDownload;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1365573081, "Lcom/baidu/webkit/internal/daemon/PacDownload;");
                return;
            }
        }
        mPacType = WebSettings.ProxyType.NO_PROXY;
    }

    public PacDownload() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mData = null;
    }

    private boolean getFreeFlowEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.mFreeFlowEnabled : invokeV.booleanValue;
    }

    public static String getUrl(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            String str = (((WebSettingsGlobalBlink.getPacUrl() + "?ProxyType=") + WebSettingsGlobalBlink.getProxyType()) + "&SdkVer=") + WebKitFactory.getSdkVersionName();
            mPacType = WebSettingsGlobalBlink.getProxyType();
            if (z) {
                str = str + "&mianliu=true";
            }
            Log.w(LOG_TAG, "get url ".concat(String.valueOf(str)));
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public static void restoreLastData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                String str = CfgFileUtils.get(CfgFileUtils.KEY_PAC_DATA, (String) null);
                if (str == null) {
                    Log.w(LOG_TAG, "restoreLastData null");
                    return;
                }
                Log.w(LOG_TAG, "restoreLastData  ".concat(String.valueOf(str)));
                WebSettingsGlobalBlink.setPacData(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void restoreLastDataFreeFLow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            try {
                String str = CfgFileUtils.get(CfgFileUtils.KEY_PAC_FREE_FLOW_DATA, (String) null);
                if (str == null) {
                    Log.w(LOG_TAG, "restoreLastDataFreeFLow null");
                    return;
                }
                Log.w(LOG_TAG, "restoreLastDataFreeFLow  ".concat(String.valueOf(str)));
                WebSettingsGlobalBlink.setPacDataFreeFlow(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void tryToDownLoadAsync(Context context) {
        String pacUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                Log.i(LOG_TAG, "tryToDownLoadAsync return");
            } else if (WebKitFactory.getCurEngine() != 1) {
                Log.w(LOG_TAG, "tryToDownLoadAsync engine not ok ");
            } else if (!WebKitFactory.getNeedDownloadCloudResource()) {
                Log.w(LOG_TAG, " tryToDownLoadAsync1  return");
                restoreLastData();
            } else {
                restoreLastData();
                if (WebSettingsGlobalBlink.getProxyType() != WebSettings.ProxyType.NO_PROXY || WebSettingsGlobalBlink.getHijackEnv()) {
                    if ((mPacFreeFlowSucced && mPacSucced) || (pacUrl = WebSettingsGlobalBlink.getPacUrl()) == null || pacUrl.length() == 0) {
                        return;
                    }
                    try {
                        PacDownload pacDownload = new PacDownload();
                        if (ResourceSchedulerEngine.getInstance().registTaskAndListener(pacDownload, null)) {
                            return;
                        }
                        BdNet bdNet = new BdNet(context);
                        bdNet.setEventListener(pacDownload);
                        BdNetTask bdNetTask = new BdNetTask();
                        bdNetTask.setNet(bdNet);
                        bdNetTask.setUrl(getUrl(context, false));
                        bdNet.start(bdNetTask, false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void tryToDownLoadAsyncFreeFlow(Context context) {
        String pacUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                Log.i(LOG_TAG, "tryToDownLoadAsyncFreeFlow return");
            } else if (WebKitFactory.getCurEngine() != 1) {
                Log.w(LOG_TAG, "tryToDownLoadAsyncFreeFlow engine not ok ");
            } else if (!WebKitFactory.getNeedDownloadCloudResource()) {
                Log.w(LOG_TAG, " tryToDownLoadAsyncFreeFlow1  return");
                restoreLastDataFreeFLow();
            } else {
                restoreLastDataFreeFLow();
                if ((WebSettingsGlobalBlink.getProxyType() == WebSettings.ProxyType.NO_PROXY && !WebSettingsGlobalBlink.getHijackEnv()) || mPacFreeFlowSucced || (pacUrl = WebSettingsGlobalBlink.getPacUrl()) == null || pacUrl.length() == 0) {
                    return;
                }
                try {
                    PacDownload pacDownload = new PacDownload();
                    pacDownload.setFreeFlowEnabled(true);
                    if (ResourceSchedulerEngine.getInstance().registTaskAndListener(pacDownload, null)) {
                        return;
                    }
                    BdNet bdNet = new BdNet(context);
                    bdNet.setEventListener(pacDownload);
                    BdNetTask bdNetTask = new BdNetTask();
                    bdNetTask.setNet(bdNet);
                    bdNetTask.setUrl(getUrl(context, true));
                    bdNet.start(bdNetTask, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getCacheFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getFreeFlowEnabled() ? "pacdownloadfreeflow.dat" : "pacdownload.dat" : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public IResourceTask.OutputType getOutputType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? IResourceTask.OutputType.STRING : (IResourceTask.OutputType) invokeV.objValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getTaskName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getFreeFlowEnabled() ? "pacdownloadfreeflow" : "pacdownload" : (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public String getTaskUrl() {
        InterceptResult invokeV;
        Context context;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getFreeFlowEnabled()) {
                context = WebViewFactory.getContext();
                z = true;
            } else {
                context = WebViewFactory.getContext();
                z = false;
            }
            return getUrl(context, z);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdNet) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048582, this, bdNet, bdNetTask, netError, i2) == null) {
            Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
            mDownloading = false;
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048583, this, bdNet, bdNetTask, bArr, i2) == null) {
            if (this.mData == null) {
                this.mData = new ByteArrayOutputStream();
            }
            this.mData.write(bArr, 0, i2);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask) == null) {
            this.mHeader = bdNetTask.getResHeaders();
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, bdNet, bdNetTask, i2)) == null) {
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, bdNet, bdNetTask, i2) == null) {
            Log.w(LOG_TAG, "onNetResponseCode  " + i2 + " url " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048587, this, bdNet, bdNetTask, netState, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bdNet, bdNetTask) == null) {
            mDownloading = false;
            ByteArrayOutputStream byteArrayOutputStream = this.mData;
            if (byteArrayOutputStream == null) {
                Log.w(LOG_TAG, "mData==null");
                return;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Log.w(LOG_TAG, "onNetDownloadComplete " + byteArray.length);
            try {
                String str = new String(byteArray, "UTF-8");
                if (getFreeFlowEnabled()) {
                    if (this.mHeader != null) {
                        String str2 = this.mHeader.get("Last-Modified");
                        Log.w(LOG_TAG, "lastModify freeflow  ".concat(String.valueOf(str2)));
                        if (str2 != null) {
                            Log.w(LOG_TAG, "lastModify1 ".concat(String.valueOf(str2)));
                            CfgFileUtils.set(CfgFileUtils.KEY_PAC_FREE_FLOW_LASTMODIFY, str2);
                        }
                    }
                    CfgFileUtils.set(CfgFileUtils.KEY_PAC_FREE_FLOW_DATA, str);
                    mPacFreeFlowSucced = true;
                    WebSettingsGlobalBlink.setPacDataFreeFlow(str);
                    return;
                }
                if (this.mHeader != null) {
                    String str3 = this.mHeader.get("Last-Modified");
                    Log.w(LOG_TAG, "lastModify ".concat(String.valueOf(str3)));
                    if (str3 != null) {
                        Log.w(LOG_TAG, "lastModify1 ".concat(String.valueOf(str3)));
                        CfgFileUtils.set(CfgFileUtils.KEY_PAC_LASTMODIFY, str3);
                    }
                }
                CfgFileUtils.set(CfgFileUtils.KEY_PAC_DATA, str);
                mPacSucced = true;
                WebSettingsGlobalBlink.setPacData(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, bdNet, bdNetTask) == null) {
            Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bdNet, bdNetTask) == null) {
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048591, this, bdNet, bdNetTask, i2, i3) == null) {
        }
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public void onResourceReady(String str, IResourceTask.ResultType resultType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, resultType) == null) {
            Log.w(LOG_TAG, "onResourceReady1 ".concat(String.valueOf(resultType)));
            if (str != null) {
                Log.w(LOG_TAG, "onResourceReady2 " + str.length());
                if (getFreeFlowEnabled()) {
                    Log.w(LOG_TAG, "onResourceReady3");
                    CfgFileUtils.set(CfgFileUtils.KEY_PAC_FREE_FLOW_DATA, str);
                    WebSettingsGlobalBlink.setPacDataFreeFlow(str);
                } else {
                    Log.w(LOG_TAG, "onResourceReady4");
                    CfgFileUtils.set(CfgFileUtils.KEY_PAC_DATA, str);
                    WebSettingsGlobalBlink.setPacData(str);
                }
            }
            ResourceSchedulerEngine.getInstance().unregistTaskAndListener(this);
        }
    }

    public void setFreeFlowEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mFreeFlowEnabled = z;
        }
    }

    @Override // com.baidu.webkit.internal.resource.IResourceTask
    public boolean shouldForceLoadFromFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
