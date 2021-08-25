package com.bytedance.sdk.component.b.b.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ad;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<ad> f64339a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64339a = new LinkedHashSet();
    }

    public synchronized void a(ad adVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adVar) == null) {
            synchronized (this) {
                this.f64339a.add(adVar);
            }
        }
    }

    public synchronized void b(ad adVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adVar) == null) {
            synchronized (this) {
                this.f64339a.remove(adVar);
            }
        }
    }

    public synchronized boolean c(ad adVar) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adVar)) == null) {
            synchronized (this) {
                contains = this.f64339a.contains(adVar);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }
}
