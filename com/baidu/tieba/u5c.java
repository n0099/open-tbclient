package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.chromium.base.Callback;
import org.chromium.base.Promise;
/* compiled from: lambda */
/* loaded from: classes8.dex */
public final /* synthetic */ class u5c implements Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Promise a;

    @Override // org.chromium.base.Callback
    public /* synthetic */ Runnable bind(T t) {
        return v5c.$default$bind(this, t);
    }

    @Override // org.chromium.base.Callback
    public final void onResult(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            this.a.reject((Exception) obj);
        }
    }
}
