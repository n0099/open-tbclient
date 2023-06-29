package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ou6 extends st6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public a k;
    public final CacheManager l;
    public wu6 m;

    @Override // com.baidu.tieba.st6
    public void l(h0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    /* loaded from: classes7.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public final void c(List<? extends Object> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(ou6 ou6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ou6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1;
            CollectionsKt__CollectionsKt.emptyList();
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a = i;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ou6(nt6 context) {
        super(context, r3, null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((nt6) objArr2[0], (k0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends pt6>[] b = nv6.a.b();
        k0 b2 = k0.d((Class[]) Arrays.copyOf(b, b.length)).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(*Families.layoutComponentTypes).get()");
        this.i = -1;
        this.j = -1;
        this.k = new a(this);
        this.l = context.b();
        this.m = new xu6();
    }

    @Override // com.baidu.tieba.st6, com.baidu.tieba.i0
    public void a(h0 entity) {
        it6 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            wu6 wu6Var = this.m;
            ut6 b = su6.b(entity);
            if (b != null && (a2 = b.a()) != null) {
                wu6Var.b(a2);
            }
        }
    }

    public final void o(wu6 wu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wu6Var) == null) {
            Intrinsics.checkNotNullParameter(wu6Var, "<set-?>");
            this.m = wu6Var;
        }
    }

    public final iv6 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ru6.c(this);
        }
        return (iv6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.st6, com.baidu.tieba.j0
    public void update(float f) {
        boolean z;
        it6 a2;
        boolean z2;
        vt6 vt6Var;
        boolean z3;
        it6 a3;
        it6 a4;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            tu6.b("LayoutSystem_update");
            ct6 c = i().c();
            if (this.i == c.r() && this.j == c.o()) {
                z = false;
            } else {
                z = true;
            }
            if (ru6.e(this) && !z) {
                tu6.a();
                return;
            }
            if (this.i != c.r()) {
                BdLog.v("DanmakuEngine [Layout] RetainerGeneration change, clear retainer.");
                this.m.c(0, (int) (n().getHeight() * c.u()));
                this.m.clear();
                this.i = c.r();
            }
            if (this.k.a() != c.l()) {
                this.k.b(c.l());
                this.k.c(CollectionsKt___CollectionsKt.toList(c.n()));
            }
            long b = ru6.b(this);
            List<h0> k = k();
            ArrayList<h0> arrayList = new ArrayList();
            for (Object obj : k) {
                tt6 d = su6.d((h0) obj);
                if (d == null || d.d()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    arrayList.add(obj);
                }
            }
            boolean z5 = false;
            for (h0 h0Var : arrayList) {
                ut6 b2 = su6.b(h0Var);
                if (b2 != null && (a4 = b2.a()) != null && a4.i() != ItemState.Measuring) {
                    boolean z6 = !a4.f().r(c.p());
                    if (a4.i().compareTo(ItemState.Measuring) < 0 || z6) {
                        if (z6 && a4.i().compareTo(ItemState.Measuring) >= 0) {
                            BdLog.v("DanmakuEngine [Layout] re-measure " + a4.e());
                        }
                        a4.p(ItemState.Measuring);
                        this.l.o(a4, n(), c);
                        z5 = true;
                    }
                }
            }
            ArrayList<h0> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                ut6 b3 = su6.b((h0) obj2);
                if (b3 != null && (a3 = b3.a()) != null && a3.i().compareTo(ItemState.Measured) >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    arrayList2.add(obj2);
                }
            }
            boolean z7 = z5;
            for (h0 h0Var2 : arrayList2) {
                ut6 b4 = su6.b(h0Var2);
                if (b4 != null && (a2 = b4.a()) != null) {
                    DrawState f2 = a2.f();
                    vt6 e = su6.e(h0Var2);
                    if (e != null || (e = (vt6) ru6.a(this, vt6.class, h0Var2, a2)) != null) {
                        vt6 vt6Var2 = e;
                        if (f2.e() != c.o()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            f2.H(false);
                            vt6Var = vt6Var2;
                            vt6Var.e(this.m.d(a2, b, n(), c));
                        } else {
                            vt6Var = vt6Var2;
                        }
                        if (vt6Var.d()) {
                            synchronized (a2.i()) {
                                if (a2.i().compareTo(ItemState.Rendering) < 0) {
                                    a2.p(ItemState.Rendering);
                                    this.l.m(a2, n(), c);
                                    z7 = true;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            this.m.a(a2, b, n(), c);
                            f2.y(c.o());
                        }
                        vt6Var.c().set(f2.g(), f2.h());
                    }
                }
            }
            if (ru6.e(this)) {
                if (z7) {
                    this.l.n();
                } else {
                    c.H();
                    this.j = c.o();
                }
            }
            tu6.a();
        }
    }
}
