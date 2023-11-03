package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;
/* loaded from: classes8.dex */
public abstract class w5c<TResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final IMessageEntity b;
    public final g5c c;
    public RequestHeader d;
    public e6c<TResult> e;

    public abstract void a(ApiException apiException, Object obj);

    public w5c(String str, IMessageEntity iMessageEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iMessageEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getClass().getSimpleName();
        this.a = str;
        this.b = iMessageEntity;
        this.c = g5c.b(str);
    }

    public final void b(ApiException apiException, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, apiException, obj) == null) {
            if (this.e != null) {
                a(apiException, obj);
                return;
            }
            String str = "This Task has been canceled, uri:" + this.a;
        }
    }
}
