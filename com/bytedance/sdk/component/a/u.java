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
    public final Set<String> f63789a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f63790b;

    /* renamed from: c  reason: collision with root package name */
    public final w f63791c;

    /* renamed from: d  reason: collision with root package name */
    public final v f63792d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f63793e;

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
        this.f63791c = r.f63777a;
        this.f63792d = vVar;
        this.f63789a = new LinkedHashSet(set);
        this.f63790b = new LinkedHashSet(set2);
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
                x xVar = this.f63790b.contains(bVar.a()) ? x.f63812a : null;
                for (String str2 : this.f63789a) {
                    if (!parse.getHost().equals(str2)) {
                        if (host.endsWith("." + str2)) {
                        }
                    }
                    xVar = x.f63814c;
                }
                if (xVar == null && this.f63793e != null && this.f63793e.a(str)) {
                    if (this.f63793e.a(str, bVar.a())) {
                        return null;
                    }
                    xVar = x.f63814c;
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (wVar = this.f63791c) == null) {
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
            this.f63793e = bVar;
        }
    }

    public void a(w.a aVar) {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (wVar = this.f63791c) == null) {
            return;
        }
        wVar.a(aVar);
    }

    private x a(@NonNull String str, @NonNull b bVar, boolean z) {
        InterceptResult invokeLLZ;
        v vVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, this, str, bVar, z)) == null) {
            if (!z || (vVar = this.f63792d) == null) {
                return null;
            }
            v.c a2 = vVar.a(str, this.f63789a);
            if (a2.f63807c.contains(bVar.a())) {
                return null;
            }
            if (a2.f63806b.contains(bVar.a())) {
                return x.f63814c;
            }
            if (a2.f63805a.compareTo(bVar.b()) < 0) {
                return null;
            }
            return a2.f63805a;
        }
        return (x) invokeLLZ.objValue;
    }
}
