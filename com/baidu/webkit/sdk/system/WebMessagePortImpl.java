package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebMessagePort;
@TargetApi(23)
/* loaded from: classes12.dex */
public final class WebMessagePortImpl extends WebMessagePort {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final android.webkit.WebMessagePort mMsgPort;

    /* loaded from: classes12.dex */
    public class WebMessageCallbackWrapper extends WebMessagePort.WebMessageCallback {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebMessagePort.WebMessageCallback mCallback;
        public final /* synthetic */ WebMessagePortImpl this$0;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-629204156, "Lcom/baidu/webkit/sdk/system/WebMessagePortImpl$WebMessageCallbackWrapper;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-629204156, "Lcom/baidu/webkit/sdk/system/WebMessagePortImpl$WebMessageCallbackWrapper;");
            }
        }

        public WebMessageCallbackWrapper(WebMessagePortImpl webMessagePortImpl, WebMessagePort.WebMessageCallback webMessageCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webMessagePortImpl, webMessageCallback};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = webMessagePortImpl;
            this.mCallback = webMessageCallback;
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(android.webkit.WebMessagePort webMessagePort, WebMessage webMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webMessagePort, webMessage) == null) {
                this.mCallback.onMessage(this.this$0, Glue.cast(webMessage));
            }
        }
    }

    public WebMessagePortImpl(android.webkit.WebMessagePort webMessagePort) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webMessagePort};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMsgPort = webMessagePort;
    }

    public static com.baidu.webkit.sdk.WebMessagePort from(android.webkit.WebMessagePort webMessagePort) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, webMessagePort)) == null) {
            if (webMessagePort == null) {
                return null;
            }
            return new WebMessagePortImpl(webMessagePort);
        }
        return (com.baidu.webkit.sdk.WebMessagePort) invokeL.objValue;
    }

    public static android.webkit.WebMessagePort[] from(com.baidu.webkit.sdk.WebMessagePort[] webMessagePortArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, webMessagePortArr)) == null) {
            if (webMessagePortArr == null) {
                return null;
            }
            android.webkit.WebMessagePort[] webMessagePortArr2 = new android.webkit.WebMessagePort[webMessagePortArr.length];
            for (int i2 = 0; i2 < webMessagePortArr.length; i2++) {
                webMessagePortArr2[i2] = ((WebMessagePortImpl) webMessagePortArr[i2]).getImpl();
            }
            return webMessagePortArr2;
        }
        return (android.webkit.WebMessagePort[]) invokeL.objValue;
    }

    public static com.baidu.webkit.sdk.WebMessagePort[] from(android.webkit.WebMessagePort[] webMessagePortArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, webMessagePortArr)) == null) {
            if (webMessagePortArr == null) {
                return null;
            }
            com.baidu.webkit.sdk.WebMessagePort[] webMessagePortArr2 = new com.baidu.webkit.sdk.WebMessagePort[webMessagePortArr.length];
            for (int i2 = 0; i2 < webMessagePortArr.length; i2++) {
                webMessagePortArr2[i2] = from(webMessagePortArr[i2]);
            }
            return webMessagePortArr2;
        }
        return (com.baidu.webkit.sdk.WebMessagePort[]) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebMessagePort
    public final void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mMsgPort.close();
        }
    }

    public final android.webkit.WebMessagePort getImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMsgPort : (android.webkit.WebMessagePort) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebMessagePort
    public final void postMessage(com.baidu.webkit.sdk.WebMessage webMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webMessage) == null) {
            this.mMsgPort.postMessage(Glue.cast(webMessage));
        }
    }

    @Override // com.baidu.webkit.sdk.WebMessagePort
    public final void setWebMessageCallback(WebMessagePort.WebMessageCallback webMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, webMessageCallback) == null) {
            setWebMessageCallback(webMessageCallback, null);
        }
    }

    @Override // com.baidu.webkit.sdk.WebMessagePort
    public final void setWebMessageCallback(WebMessagePort.WebMessageCallback webMessageCallback, Handler handler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webMessageCallback, handler) == null) || webMessageCallback == null) {
            return;
        }
        this.mMsgPort.setWebMessageCallback(new WebMessageCallbackWrapper(this, webMessageCallback), handler);
    }
}
