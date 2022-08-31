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
public final class t36 extends x26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public a k;
    public final CacheManager l;
    public b46 m;

    /* loaded from: classes5.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(t36 this$0) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a = i;
            }
        }

        public final void c(List<? extends Object> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public t36(s26 context) {
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
                super((s26) objArr2[0], (r0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends u26>[] b = s46.a.b();
        r0 b2 = r0.d((Class[]) Arrays.copyOf(b, b.length)).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(*Families.layoutComponentTypes).get()");
        this.i = -1;
        this.j = -1;
        this.k = new a(this);
        this.l = context.b();
        this.m = new c46();
    }

    @Override // com.baidu.tieba.x26, com.baidu.tieba.p0
    public void a(o0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            b46 b46Var = this.m;
            z26 b = x36.b(entity);
            n26 a2 = b == null ? null : b.a();
            if (a2 == null) {
                return;
            }
            b46Var.b(a2);
        }
    }

    @Override // com.baidu.tieba.x26
    public void l(o0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    public final n46 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? w36.c(this) : (n46) invokeV.objValue;
    }

    public final b46 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (b46) invokeV.objValue;
    }

    public final void p(b46 b46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b46Var) == null) {
            Intrinsics.checkNotNullParameter(b46Var, "<set-?>");
            this.m = b46Var;
        }
    }

    @Override // com.baidu.tieba.x26, com.baidu.tieba.q0
    public void update(float f) {
        a36 a36Var;
        DrawState drawState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            y36.b("LayoutSystem_update");
            h26 c = i().c();
            boolean z = false;
            boolean z2 = (this.i == c.r() && this.j == c.o()) ? false : true;
            if (w36.e(this) && !z2) {
                y36.a();
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
            long b = w36.b(this);
            List<o0> k = k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : k) {
                y26 d = x36.d((o0) obj);
                if ((d == null || d.d()) ? false : true) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            boolean z3 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                z26 b2 = x36.b((o0) it.next());
                n26 a2 = b2 != null ? b2.a() : null;
                if (a2 != null && a2.i() != ItemState.Measuring) {
                    boolean z4 = !a2.f().r(c.p());
                    if (a2.i().compareTo(ItemState.Measuring) < 0 || z4) {
                        if (z4 && a2.i().compareTo(ItemState.Measuring) >= 0) {
                            BdLog.v(Intrinsics.stringPlus("DanmakuEngine [Layout] re-measure ", a2.e()));
                        }
                        a2.o(ItemState.Measuring);
                        this.l.o(a2, n(), c);
                        z3 = true;
                    }
                }
            }
            ArrayList<o0> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                z26 b3 = x36.b((o0) obj2);
                n26 a3 = b3 == null ? null : b3.a();
                if (a3 != null && a3.i().compareTo(ItemState.Measured) >= 0) {
                    arrayList2.add(obj2);
                }
            }
            boolean z5 = z3;
            for (o0 o0Var : arrayList2) {
                z26 b4 = x36.b(o0Var);
                n26 a4 = b4 == null ? null : b4.a();
                if (a4 != null) {
                    DrawState f2 = a4.f();
                    a36 e = x36.e(o0Var);
                    if (e != null || (e = (a36) w36.a(this, a36.class, o0Var, a4)) != null) {
                        a36 a36Var2 = e;
                        if (f2.e() != c.o()) {
                            f2.H(z);
                            a36Var = a36Var2;
                            drawState = f2;
                            a36Var.e(o().d(a4, b, n(), c));
                        } else {
                            a36Var = a36Var2;
                            drawState = f2;
                        }
                        if (a36Var.d()) {
                            synchronized (a4.i()) {
                                if (a4.i().compareTo(ItemState.Rendering) < 0) {
                                    a4.o(ItemState.Rendering);
                                    this.l.m(a4, n(), c);
                                    z5 = true;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            o().a(a4, b, n(), c);
                            drawState.y(c.o());
                        }
                        a36Var.c().set(drawState.g(), drawState.h());
                        z = false;
                    }
                }
            }
            if (w36.e(this)) {
                if (z5) {
                    this.l.n();
                } else {
                    c.H();
                    this.j = c.o();
                }
            }
            y36.a();
        }
    }
}
