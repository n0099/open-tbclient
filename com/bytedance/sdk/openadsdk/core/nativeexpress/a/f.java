package com.bytedance.sdk.openadsdk.core.nativeexpress.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class f implements e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p f30531a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public List<e> f30532b;

    /* renamed from: c  reason: collision with root package name */
    public d f30533c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f30534d;

    public f(List<e> list, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30534d = new AtomicBoolean(false);
        this.f30532b = list;
        this.f30533c = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30533c.a();
            Iterator<e> it = this.f30532b.iterator();
            while (it.hasNext() && !it.next().a(this)) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e.a
    public boolean b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            int indexOf = this.f30532b.indexOf(eVar);
            return indexOf < this.f30532b.size() - 1 && indexOf >= 0;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30534d.get() : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e.a
    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30531a : (p) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e.a
    public void a(e eVar) {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || (indexOf = this.f30532b.indexOf(eVar)) < 0) {
            return;
        }
        do {
            indexOf++;
            if (indexOf >= this.f30532b.size()) {
                return;
            }
        } while (!this.f30532b.get(indexOf).a(this));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e.a
    public void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            this.f30531a = pVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.e.a
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f30534d.getAndSet(z);
        }
    }
}
