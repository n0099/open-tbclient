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
/* loaded from: classes6.dex */
public abstract class jq6 extends hq6 implements j0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l0 e;
    public final Comparator<i0> f;
    public final List<i0> g;
    public boolean h;

    @Override // com.baidu.tieba.hq6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public abstract void m(i0 i0Var, float f);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jq6(eq6 context, l0 family, Comparator<i0> comparator) {
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
                super((eq6) newInitContext.callArgs[0]);
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

    public /* synthetic */ jq6(eq6 eq6Var, l0 l0Var, Comparator comparator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eq6Var, l0Var, (i & 4) != 0 ? new iq6() : comparator);
    }

    public void a(i0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.g.remove(entity);
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.j0
    public void b(i0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.g.add(entity);
            this.h = true;
        }
    }

    @Override // com.baidu.tieba.hq6, com.baidu.tieba.k0
    public void g(h0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            engine.o(this);
            this.g.clear();
            this.h = false;
        }
    }

    @Override // com.baidu.tieba.k0
    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            n();
            for (i0 i0Var : this.g) {
                m(i0Var, f);
            }
        }
    }

    @Override // com.baidu.tieba.k0
    public void c(h0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.g.clear();
            s0<i0> newEntities = engine.j(this.e);
            if (newEntities.size() > 0) {
                List<i0> list = this.g;
                Intrinsics.checkNotNullExpressionValue(newEntities, "newEntities");
                CollectionsKt__MutableCollectionsKt.addAll(list, newEntities);
            }
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.g, this.f);
            this.h = false;
            engine.f(this.e, this);
        }
    }

    public final List<i0> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            n();
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.h) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.g, this.f);
            this.h = false;
        }
    }
}
