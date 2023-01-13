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
/* loaded from: classes5.dex */
public final class nc6 extends rb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public a k;
    public final CacheManager l;
    public vc6 m;

    @Override // com.baidu.tieba.rb6
    public void l(q0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    /* loaded from: classes5.dex */
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
        public a(nc6 this$0) {
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
    public nc6(mb6 context) {
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
                super((mb6) objArr2[0], (t0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends ob6>[] b = md6.a.b();
        t0 b2 = t0.d((Class[]) Arrays.copyOf(b, b.length)).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(*Families.layoutComponentTypes).get()");
        this.i = -1;
        this.j = -1;
        this.k = new a(this);
        this.l = context.b();
        this.m = new wc6();
    }

    @Override // com.baidu.tieba.rb6, com.baidu.tieba.r0
    public void a(q0 entity) {
        hb6 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            vc6 vc6Var = this.m;
            tb6 b = rc6.b(entity);
            if (b == null) {
                a2 = null;
            } else {
                a2 = b.a();
            }
            if (a2 == null) {
                return;
            }
            vc6Var.b(a2);
        }
    }

    public final void p(vc6 vc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vc6Var) == null) {
            Intrinsics.checkNotNullParameter(vc6Var, "<set-?>");
            this.m = vc6Var;
        }
    }

    public final hd6 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return qc6.c(this);
        }
        return (hd6) invokeV.objValue;
    }

    public final vc6 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (vc6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rb6, com.baidu.tieba.s0
    public void update(float f) {
        boolean z;
        hb6 a2;
        boolean z2;
        ub6 ub6Var;
        DrawState drawState;
        hb6 a3;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            sc6.b("LayoutSystem_update");
            bb6 c = i().c();
            boolean z5 = false;
            if (this.i == c.r() && this.j == c.o()) {
                z = false;
            } else {
                z = true;
            }
            if (qc6.e(this) && !z) {
                sc6.a();
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
            long b = qc6.b(this);
            List<q0> k = k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : k) {
                sb6 d = rc6.d((q0) obj);
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
                hb6 hb6Var = null;
                if (!it.hasNext()) {
                    break;
                }
                tb6 b2 = rc6.b((q0) it.next());
                if (b2 != null) {
                    hb6Var = b2.a();
                }
                if (hb6Var != null && hb6Var.i() != ItemState.Measuring) {
                    boolean z7 = !hb6Var.f().r(c.p());
                    if (hb6Var.i().compareTo(ItemState.Measuring) < 0 || z7) {
                        if (z7 && hb6Var.i().compareTo(ItemState.Measuring) >= 0) {
                            BdLog.v(Intrinsics.stringPlus("DanmakuEngine [Layout] re-measure ", hb6Var.e()));
                        }
                        hb6Var.o(ItemState.Measuring);
                        this.l.o(hb6Var, n(), c);
                        z6 = true;
                    }
                }
            }
            ArrayList<q0> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                tb6 b3 = rc6.b((q0) obj2);
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
            for (q0 q0Var : arrayList2) {
                tb6 b4 = rc6.b(q0Var);
                if (b4 == null) {
                    a2 = null;
                } else {
                    a2 = b4.a();
                }
                if (a2 != null) {
                    DrawState f2 = a2.f();
                    ub6 e = rc6.e(q0Var);
                    if (e != null || (e = (ub6) qc6.a(this, ub6.class, q0Var, a2)) != null) {
                        ub6 ub6Var2 = e;
                        if (f2.e() != c.o()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            f2.H(z5);
                            ub6Var = ub6Var2;
                            drawState = f2;
                            ub6Var.e(o().d(a2, b, n(), c));
                        } else {
                            ub6Var = ub6Var2;
                            drawState = f2;
                        }
                        if (ub6Var.d()) {
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
                        ub6Var.c().set(drawState.g(), drawState.h());
                        z5 = false;
                    }
                }
            }
            if (qc6.e(this)) {
                if (z8) {
                    this.l.n();
                } else {
                    c.H();
                    this.j = c.o();
                }
            }
            sc6.a();
        }
    }
}
