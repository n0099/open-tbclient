package com.baidu.webkit.internal.blink;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* loaded from: classes9.dex */
public final class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f63396a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        super(engineManager, webkitInstallListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, engineManager, webkitInstallListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                this.f63396a = substring;
            }
        }
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63396a != null : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63396a : (String) invokeV.objValue;
    }
}
