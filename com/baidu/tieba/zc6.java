package com.baidu.tieba;

import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.util.Map;
/* loaded from: classes7.dex */
public class zc6 extends yc6<WebResourceResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc6(yc6<WebResourceResponse> yc6Var) {
        super(yc6Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yc6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yc6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.yc6
    public boolean d(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map)) == null) {
            return nc6.a().contains(ue6.a(str));
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yc6
    /* renamed from: e */
    public WebResourceResponse c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, map)) == null) {
            String a = ue6.a(str);
            try {
                dd6 dd6Var = nc6.a().get(a);
                if (dd6Var != null && dd6Var.c()) {
                    ke6.b("lt-log", "hit memory cache:" + str);
                    WebResourceResponse b = dd6Var.b();
                    b.setData(new ByteArrayInputStream(dd6Var.a()));
                    return b;
                }
                return null;
            } catch (Exception e) {
                nc6.a().remove(a);
                e.printStackTrace();
                return null;
            }
        }
        return (WebResourceResponse) invokeLL.objValue;
    }
}
