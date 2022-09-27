package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x81 {
    public static /* synthetic */ Interceptable $ic;
    public static x81 b;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public se1<IWebViewDataDirectoryManager> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254136, "Lcom/baidu/tieba/x81;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254136, "Lcom/baidu/tieba/x81;");
                return;
            }
        }
        b = new x81();
    }

    public x81() {
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
        b();
    }

    public static x81 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : (x81) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            qe1 b2 = qe1.b();
            this.a = b2;
            b2.a(new IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider());
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (q91.a()) {
                Log.i("NPS-WebViewDataDirec", "webViewDataDirectoryManagerHolder class=" + this.a.getClass());
            }
            this.a.get().setDataDirectorySuffix();
        }
    }
}
