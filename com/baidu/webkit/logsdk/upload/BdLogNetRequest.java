package com.baidu.webkit.logsdk.upload;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.RC4;
import com.baidu.webkit.logsdk.d;
import com.baidu.webkit.logsdk.d.c;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BdLogNetRequest implements INetListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TIMEOUT = 30000;
    public transient /* synthetic */ FieldHolder $fh;
    public d mCallback;
    public ByteArrayOutputStream mData;
    public boolean mIsConfig;

    public BdLogNetRequest(d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsConfig = z;
        this.mCallback = dVar;
    }

    public static void requestConfig(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, dVar) == null) {
            c.e("BdLogSDK", "requestConfig, url1: ".concat(String.valueOf(str)));
            BdNet bdNet = new BdNet(WebKitFactory.getContext());
            bdNet.setEventListener(new BdLogNetRequest(dVar, true));
            BdNetTask bdNetTask = new BdNetTask();
            bdNetTask.setNet(bdNet);
            bdNetTask.setUrl(str);
            bdNet.start(bdNetTask, false);
        }
    }

    public static void uploadLog(String str, JSONObject jSONObject, File file, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, jSONObject, file, dVar) == null) {
            byte[] bytes = jSONObject.toString().getBytes();
            c.e("BdLogSDK", "uploadLog " + jSONObject.toString());
            try {
                HashMap hashMap = new HashMap();
                BdNet bdNet = new BdNet(WebKitFactory.getContext());
                bdNet.setEventListener(new BdLogNetRequest(dVar, false));
                BdNetTask bdNetTask = new BdNetTask();
                bdNetTask.setMethod(BdNet.HttpMethod.METHOD_POST);
                bdNetTask.setNet(bdNet);
                bdNetTask.setUrl(str);
                hashMap.put("Content-Type", "application/x-gzip");
                if (WebKitFactory.getCurEngine() != 1) {
                    hashMap.put("Kernel-Status", "0");
                }
                bdNetTask.setHeaders(hashMap);
                bdNetTask.setContent(RC4.kernelEncrypt(RC4.kernelGzipCompress(bytes)));
                bdNet.start(bdNetTask, false);
            } catch (Exception e) {
                e.printStackTrace();
                dVar.a(null);
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdNet) == null) {
            c.e("BdLogSDK", "onNetDownloadComplete  ");
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdNet, bdNetTask, netError, i) == null) {
            c.e("BdLogSDK", "onNetDownloadError  " + bdNetTask.getUrl());
            this.mCallback.a(null);
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, bdNet, bdNetTask, bArr, i) == null) {
            c.e("BdLogSDK", "onNetReceiveData  ".concat(String.valueOf(i)));
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
            c.e("BdLogSDK", "onNetTaskComplete  " + bdNetTask.getUrl());
            if (this.mIsConfig) {
                c.e("BdLogSDK", "onNetTaskComplete1  " + bdNetTask.getUrl());
                this.mCallback.a(this.mData.toByteArray());
                return;
            }
            c.e("BdLogSDK", "onNetTaskComplete2  " + bdNetTask.getUrl());
            this.mCallback.a(new String("OK").getBytes());
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask) == null) {
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
