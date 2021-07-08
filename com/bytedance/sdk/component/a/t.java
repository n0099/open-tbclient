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
import com.bytedance.sdk.component.a.u;
import com.bytedance.sdk.component.a.v;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f27793a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f27794b;

    /* renamed from: c  reason: collision with root package name */
    public final v f27795c;

    /* renamed from: d  reason: collision with root package name */
    public final u f27796d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f27797e;

    public t(@Nullable u uVar, @NonNull Set<String> set, @NonNull Set<String> set2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar, set, set2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27795c = q.f27781a;
        this.f27796d = uVar;
        this.f27793a = new LinkedHashSet(set);
        this.f27794b = new LinkedHashSet(set2);
    }

    @MainThread
    public final synchronized w a(boolean z, String str, b bVar) throws u.a {
        InterceptResult invokeCommon;
        w b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, bVar})) == null) {
            synchronized (this) {
                Uri parse = Uri.parse(str);
                String host = parse.getHost();
                if (host == null) {
                    return null;
                }
                w wVar = this.f27794b.contains(bVar.a()) ? w.f27816a : null;
                for (String str2 : this.f27793a) {
                    if (!parse.getHost().equals(str2)) {
                        if (host.endsWith("." + str2)) {
                        }
                    }
                    wVar = w.f27818c;
                }
                if (wVar == null && this.f27797e != null && this.f27797e.a(str)) {
                    if (this.f27797e.a(str, bVar.a())) {
                        return null;
                    }
                    wVar = w.f27818c;
                }
                if (z) {
                    b2 = a(str, bVar);
                } else {
                    b2 = b(str, bVar);
                }
                return b2 != null ? b2 : wVar;
            }
        }
        return (w) invokeCommon.objValue;
    }

    public final synchronized w b(@NonNull String str, @NonNull b bVar) {
        InterceptResult invokeLL;
        w a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bVar)) == null) {
            synchronized (this) {
                a2 = a(str, bVar, false);
            }
            return a2;
        }
        return (w) invokeLL.objValue;
    }

    public void b(v.a aVar) {
        v vVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (vVar = this.f27795c) == null) {
            return;
        }
        vVar.b(aVar);
    }

    @MainThread
    public final synchronized w a(@NonNull String str, @NonNull b bVar) throws u.a {
        InterceptResult invokeLL;
        w a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bVar)) == null) {
            synchronized (this) {
                a2 = a(str, bVar, true);
            }
            return a2;
        }
        return (w) invokeLL.objValue;
    }

    public void a(@Nullable k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f27797e = bVar;
        }
    }

    public void a(v.a aVar) {
        v vVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || (vVar = this.f27795c) == null) {
            return;
        }
        vVar.a(aVar);
    }

    private w a(@NonNull String str, @NonNull b bVar, boolean z) {
        InterceptResult invokeLLZ;
        u uVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, this, str, bVar, z)) == null) {
            if (!z || (uVar = this.f27796d) == null) {
                return null;
            }
            u.c a2 = uVar.a(str, this.f27793a);
            if (a2.f27811c.contains(bVar.a())) {
                return null;
            }
            if (a2.f27810b.contains(bVar.a())) {
                return w.f27818c;
            }
            if (a2.f27809a.compareTo(bVar.b()) < 0) {
                return null;
            }
            return a2.f27809a;
        }
        return (w) invokeLLZ.objValue;
    }
}
