package com.baidu.webkit.internal.monitor;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.RC4;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public class SessionMonitorNetWorker implements INoProGuard, INetListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "ZeusMonitorEngine";
    public static boolean mLogSdkInit;
    public transient /* synthetic */ FieldHolder $fh;

    public SessionMonitorNetWorker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String getUploadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? WebSettingsGlobalBlink.getSessionUploadUrl() : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStatisticsDataToServer(byte[] bArr, String str, boolean z) {
        String GetCloudSettingsValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, this, bArr, str, z) == null) {
            String uploadUrl = getUploadUrl();
            if (TextUtils.isEmpty(uploadUrl)) {
                return;
            }
            String str2 = uploadUrl + str;
            if (bArr != null) {
                try {
                    if (bArr.length <= 0) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    BdNet bdNet = new BdNet(WebKitFactory.getContext());
                    BdNetTask bdNetTask = new BdNetTask();
                    bdNetTask.setMethod(BdNet.HttpMethod.METHOD_POST);
                    bdNetTask.setNet(bdNet);
                    bdNetTask.setUrl(str2);
                    bdNetTask.setContent(bArr);
                    hashMap.put(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    hashMap.put(Headers.CACHE_CONTROL, "no-cache");
                    if (WebSettingsGlobalBlink.isSessionDataEnable() && ((GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support")) == null || !GetCloudSettingsValue.equals("false"))) {
                        hashMap.put("Content-Type", "application/x-gzip");
                    }
                    if (WebKitFactory.getCurEngine() != 1) {
                        hashMap.put("Kernel-Status", "0");
                    }
                    bdNetTask.setHeaders(hashMap);
                    if (!z) {
                        bdNet.setEventListener(this);
                    }
                    bdNet.start(bdNetTask, false);
                    if (z) {
                        return;
                    }
                    synchronized (bdNetTask) {
                        bdNetTask.wait();
                    }
                } catch (Exception e) {
                    Log.d(LOG_TAG, "upload error ".concat(String.valueOf(e)));
                }
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdNet) == null) {
            Log.i(LOG_TAG, "onNetDownloadComplete()");
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdNet, bdNetTask, netError, i) == null) {
            Log.i(LOG_TAG, "onNetDownloadError()");
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, bdNet, bdNetTask, bArr, i) == null) {
            Log.i(LOG_TAG, "onNetReceiveData()");
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
            Log.i(LOG_TAG, "onNetRedirect()");
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, bdNet, bdNetTask, i) == null) {
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
            Log.i(LOG_TAG, "onNetTaskComplete()");
            synchronized (bdNetTask) {
                bdNetTask.notify();
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask) == null) {
            Log.i(LOG_TAG, "onNetTaskStart()");
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdNet, bdNetTask) == null) {
            Log.i(LOG_TAG, "onNetUploadComplete()");
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048586, this, bdNet, bdNetTask, i, i2) == null) {
        }
    }

    public void upload(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            upload(str, str2, str3, true);
        }
    }

    public void upload(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                Log.i(LOG_TAG, "upload closed by isSFSwitchEnabled");
                return;
            }
            Runnable runnable = new Runnable(this, str2, str, str3, z) { // from class: com.baidu.webkit.internal.monitor.SessionMonitorNetWorker.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ String b;
                public final /* synthetic */ String c;
                public final /* synthetic */ boolean d;
                public final /* synthetic */ SessionMonitorNetWorker e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, str, str3, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = str2;
                    this.b = str;
                    this.c = str3;
                    this.d = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.a)) {
                        return;
                    }
                    if (WebSettingsGlobalBlink.isSessionDataEnable()) {
                        Log.i(SessionMonitorNetWorker.LOG_TAG, "aContent=" + this.a);
                        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
                        if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false")) {
                            try {
                                if (!WebSettingsGlobalBlink.getLogsdkEnabled() && !WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                                    this.e.sendStatisticsDataToServer(RC4.kernelEncrypt(RC4.kernelGzipCompress(this.a.getBytes())), this.c, this.d);
                                }
                                if (!SessionMonitorNetWorker.mLogSdkInit) {
                                    Log.i(SessionMonitorNetWorker.LOG_TAG, "BdLogSDK.init1");
                                    com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                                    boolean unused = SessionMonitorNetWorker.mLogSdkInit = true;
                                }
                                com.baidu.webkit.logsdk.a.a(this.b, this.a);
                                if (WebSettingsGlobalBlink.getDoubleLogEnabled()) {
                                    this.e.sendStatisticsDataToServer(RC4.kernelEncrypt(RC4.kernelGzipCompress(this.a.getBytes())), this.c, this.d);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (WebSettingsGlobalBlink.useLogSdk()) {
                            if (!SessionMonitorNetWorker.mLogSdkInit) {
                                Log.i(SessionMonitorNetWorker.LOG_TAG, "BdLogSDK.init2");
                                com.baidu.webkit.logsdk.a.a(WebKitFactory.getContext(), new c());
                                boolean unused2 = SessionMonitorNetWorker.mLogSdkInit = true;
                            }
                            com.baidu.webkit.logsdk.a.a(this.b, this.a);
                        } else {
                            this.e.sendStatisticsDataToServer(RC4.kernelEncrypt(Base64.encode(this.a.getBytes(), false)), this.c, this.d);
                        }
                    }
                    if (WebSettingsGlobalBlink.useT5Log()) {
                        this.e.sendStatisticsDataToServer(RC4.kernelEncrypt(Base64.encode(this.a.getBytes(), false)), this.c, this.d);
                    }
                }
            };
            if (z) {
                ZeusThreadPoolUtil.executeIgnoreZeus(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void uploadFromFile(String str, byte[] bArr, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, bArr, str2) == null) {
            if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
                Log.i(LOG_TAG, "upload closed by isSFSwitchEnabled");
            } else {
                ZeusThreadPoolUtil.executeIgnoreZeus(new Runnable(this, bArr, str2) { // from class: com.baidu.webkit.internal.monitor.SessionMonitorNetWorker.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ byte[] a;
                    public final /* synthetic */ String b;
                    public final /* synthetic */ SessionMonitorNetWorker c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bArr, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.c = this;
                        this.a = bArr;
                        this.b = str2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        byte[] bArr2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (bArr2 = this.a) == null || bArr2.length == 0 || !WebSettingsGlobalBlink.isSessionDataEnable()) {
                            return;
                        }
                        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("gzip_support");
                        if (GetCloudSettingsValue == null || !GetCloudSettingsValue.equals("false")) {
                            this.c.sendStatisticsDataToServer(this.a, this.b, true);
                        }
                    }
                });
            }
        }
    }
}
