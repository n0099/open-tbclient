package com.bytedance.sdk.component.a;

import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.k;
import com.bytedance.sdk.component.a.v;
import com.bytedance.sdk.component.a.w;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f64480a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f64481b;

    /* renamed from: c  reason: collision with root package name */
    public final w f64482c;

    /* renamed from: d  reason: collision with root package name */
    public final v f64483d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f64484e;

    public u(@Nullable v vVar, @NonNull Set<String> set, @NonNull Set<String> set2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vVar, set, set2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64482c = r.f64468a;
        this.f64483d = vVar;
        this.f64480a = new LinkedHashSet(set);
        this.f64481b = new LinkedHashSet(set2);
    }

    @MainThread
    public final synchronized x a(boolean z, String str, b bVar) throws v.a {
        InterceptResult invokeCommon;
        x b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, bVar})) == null) {
            synchronized (this) {
                Uri parse = Uri.parse(str);
                String host = parse.getHost();
                if (host == null) {
                    return null;
                }
                x xVar = this.f64481b.contains(bVar.a()) ? x.f64503a : null;
                for (String str2 : this.f64480a) {
                    if (!parse.getHost().equals(str2)) {
                        if (host.endsWith("." + str2)) {
                        }
                    }
                    xVar = x.f64505c;
                }
                if (xVar == null && this.f64484e != null && this.f64484e.a(str)) {
                    if (this.f64484e.a(str, bVar.a())) {
                        return null;
                    }
                    xVar = x.f64505c;
                }
                if (z) {
                    b2 = a(str, bVar);
                } else {
                    b2 = b(str, bVar);
                }
                return b2 != null ? b2 : xVar;
            }
        }
        return (x) invokeCommon.objValue;
    }

    public final synchronized x b(@NonNull String str, @NonNull b bVar) {
        InterceptResult invokeLL;
        x a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bVar)) == null) {
            synchronized (this) {
                a2 = a(str, bVar, false);
            }
            return a2;
        }
        return (x) invokeLL.objValue;
    }

    public void b(w.a aVar) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (wVar = this.f64482c) == null) {
            return;
        }
        wVar.b(aVar);
    }

    @MainThread
    public final synchronized x a(@NonNull String str, @NonNull b bVar) throws v.a {
        InterceptResult invokeLL;
        x a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bVar)) == null) {
            synchronized (this) {
                a2 = a(str, bVar, true);
            }
            return a2;
        }
        return (x) invokeLL.objValue;
    }

    public void a(@Nullable k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f64484e = bVar;
        }
    }

    public void a(w.a aVar) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (wVar = this.f64482c) == null) {
            return;
        }
        wVar.a(aVar);
    }

    private x a(@NonNull String str, @NonNull b bVar, boolean z) {
        InterceptResult invokeLLZ;
        v vVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, this, str, bVar, z)) == null) {
            if (!z || (vVar = this.f64483d) == null) {
                return null;
            }
            v.c a2 = vVar.a(str, this.f64480a);
            if (a2.f64498c.contains(bVar.a())) {
                return null;
            }
            if (a2.f64497b.contains(bVar.a())) {
                return x.f64505c;
            }
            if (a2.f64496a.compareTo(bVar.b()) < 0) {
                return null;
            }
            return a2.f64496a;
        }
        return (x) invokeLLZ.objValue;
    }
}
