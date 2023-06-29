package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class st6 extends qt6 implements i0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k0 e;
    public final Comparator<h0> f;
    public final List<h0> g;
    public boolean h;

    @Override // com.baidu.tieba.qt6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public abstract void l(h0 h0Var, float f);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public st6(nt6 context, k0 family, Comparator<h0> comparator) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, family, comparator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nt6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.e = family;
        this.f = comparator;
        this.g = new ArrayList();
    }

    public /* synthetic */ st6(nt6 nt6Var, k0 k0Var, Comparator comparator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nt6Var, k0Var, (i & 4) != 0 ? new rt6() : comparator);
    }

    public void a(h0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.g.remove(entity);
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.i0
    public void b(h0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.g.add(entity);
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.qt6, com.baidu.tieba.j0
    public void g(g0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            engine.o(this);
            this.g.clear();
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.j0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            m();
            for (h0 h0Var : this.g) {
                l(h0Var, f);
            }
        }
    }

    @Override // com.baidu.tieba.j0
    public void c(g0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.g.clear();
            r0<h0> newEntities = engine.j(this.e);
            if (newEntities.size() > 0) {
                List<h0> list = this.g;
                Intrinsics.checkNotNullExpressionValue(newEntities, "newEntities");
                CollectionsKt__MutableCollectionsKt.addAll(list, newEntities);
            }
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.g, this.f);
            this.h = false;
            engine.f(this.e, this);
        }
    }

    public final List<h0> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            m();
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.h) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.g, this.f);
            this.h = false;
        }
    }
}
