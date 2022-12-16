package com.baidu.webkit.internal.blink;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* loaded from: classes7.dex */
public final class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        super(engineManager, webkitInstallListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, engineManager, webkitInstallListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((EngineManager) objArr2[0], (WebKitFactory.WebkitInstallListener) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (str != null) {
            String substring = str.substring(7);
            if (new File(substring).isFile()) {
                this.a = substring;
            }
        }
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
