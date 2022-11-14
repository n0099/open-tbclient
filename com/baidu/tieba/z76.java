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
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class z76 extends d76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public a k;
    public final CacheManager l;
    public h86 m;

    @Override // com.baidu.tieba.d76
    public void l(p0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    /* loaded from: classes6.dex */
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
        public a(z76 this$0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(this$0, "this$0");
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
    public z76(y66 context) {
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
                super((y66) objArr2[0], (s0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends a76>[] b = y86.a.b();
        s0 b2 = s0.d((Class[]) Arrays.copyOf(b, b.length)).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(*Families.layoutComponentTypes).get()");
        this.i = -1;
        this.j = -1;
        this.k = new a(this);
        this.l = context.b();
        this.m = new i86();
    }

    @Override // com.baidu.tieba.d76, com.baidu.tieba.q0
    public void a(p0 entity) {
        t66 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            h86 h86Var = this.m;
            f76 b = d86.b(entity);
            if (b == null) {
                a2 = null;
            } else {
                a2 = b.a();
            }
            if (a2 == null) {
                return;
            }
            h86Var.b(a2);
        }
    }

    public final void p(h86 h86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h86Var) == null) {
            Intrinsics.checkNotNullParameter(h86Var, "<set-?>");
            this.m = h86Var;
        }
    }

    public final t86 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return c86.c(this);
        }
        return (t86) invokeV.objValue;
    }

    public final h86 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (h86) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d76, com.baidu.tieba.r0
    public void update(float f) {
        boolean z;
        t66 a2;
        boolean z2;
        g76 g76Var;
        DrawState drawState;
        t66 a3;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            e86.b("LayoutSystem_update");
            n66 c = i().c();
            boolean z5 = false;
            if (this.i == c.r() && this.j == c.o()) {
                z = false;
            } else {
                z = true;
            }
            if (c86.e(this) && !z) {
                e86.a();
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
            long b = c86.b(this);
            List<p0> k = k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : k) {
                e76 d = d86.d((p0) obj);
                if (d == null || d.d()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            boolean z6 = false;
            while (true) {
                t66 t66Var = null;
                if (!it.hasNext()) {
                    break;
                }
                f76 b2 = d86.b((p0) it.next());
                if (b2 != null) {
                    t66Var = b2.a();
                }
                if (t66Var != null && t66Var.i() != ItemState.Measuring) {
                    boolean z7 = !t66Var.f().r(c.p());
                    if (t66Var.i().compareTo(ItemState.Measuring) < 0 || z7) {
                        if (z7 && t66Var.i().compareTo(ItemState.Measuring) >= 0) {
                            BdLog.v(Intrinsics.stringPlus("DanmakuEngine [Layout] re-measure ", t66Var.e()));
                        }
                        t66Var.o(ItemState.Measuring);
                        this.l.o(t66Var, n(), c);
                        z6 = true;
                    }
                }
            }
            ArrayList<p0> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                f76 b3 = d86.b((p0) obj2);
                if (b3 == null) {
                    a3 = null;
                } else {
                    a3 = b3.a();
                }
                if (a3 == null || a3.i().compareTo(ItemState.Measured) < 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    arrayList2.add(obj2);
                }
            }
            boolean z8 = z6;
            for (p0 p0Var : arrayList2) {
                f76 b4 = d86.b(p0Var);
                if (b4 == null) {
                    a2 = null;
                } else {
                    a2 = b4.a();
                }
                if (a2 != null) {
                    DrawState f2 = a2.f();
                    g76 e = d86.e(p0Var);
                    if (e != null || (e = (g76) c86.a(this, g76.class, p0Var, a2)) != null) {
                        g76 g76Var2 = e;
                        if (f2.e() != c.o()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            f2.H(z5);
                            g76Var = g76Var2;
                            drawState = f2;
                            g76Var.e(o().d(a2, b, n(), c));
                        } else {
                            g76Var = g76Var2;
                            drawState = f2;
                        }
                        if (g76Var.d()) {
                            synchronized (a2.i()) {
                                if (a2.i().compareTo(ItemState.Rendering) < 0) {
                                    a2.o(ItemState.Rendering);
                                    this.l.m(a2, n(), c);
                                    z8 = true;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            o().a(a2, b, n(), c);
                            drawState.y(c.o());
                        }
                        g76Var.c().set(drawState.g(), drawState.h());
                        z5 = false;
                    }
                }
            }
            if (c86.e(this)) {
                if (z8) {
                    this.l.n();
                } else {
                    c.H();
                    this.j = c.o();
                }
            }
            e86.a();
        }
    }
}
