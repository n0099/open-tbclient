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
public final class w56 extends a56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public int j;
    public a k;
    public final CacheManager l;
    public e66 m;

    /* loaded from: classes6.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(w56 this$0) {
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
    public w56(v46 context) {
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
                super((v46) objArr2[0], (s0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends x46>[] b = v66.a.b();
        s0 b2 = s0.d((Class[]) Arrays.copyOf(b, b.length)).b();
        Intrinsics.checkNotNullExpressionValue(b2, "all(*Families.layoutComponentTypes).get()");
        this.i = -1;
        this.j = -1;
        this.k = new a(this);
        this.l = context.b();
        this.m = new f66();
    }

    @Override // com.baidu.tieba.a56, com.baidu.tieba.q0
    public void a(p0 entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super.a(entity);
            e66 e66Var = this.m;
            c56 b = a66.b(entity);
            q46 a2 = b == null ? null : b.a();
            if (a2 == null) {
                return;
            }
            e66Var.b(a2);
        }
    }

    @Override // com.baidu.tieba.a56
    public void l(p0 entity, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    public final q66 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? z56.c(this) : (q66) invokeV.objValue;
    }

    public final e66 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m : (e66) invokeV.objValue;
    }

    public final void p(e66 e66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e66Var) == null) {
            Intrinsics.checkNotNullParameter(e66Var, "<set-?>");
            this.m = e66Var;
        }
    }

    @Override // com.baidu.tieba.a56, com.baidu.tieba.r0
    public void update(float f) {
        d56 d56Var;
        DrawState drawState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            b66.b("LayoutSystem_update");
            k46 c = i().c();
            boolean z = false;
            boolean z2 = (this.i == c.r() && this.j == c.o()) ? false : true;
            if (z56.e(this) && !z2) {
                b66.a();
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
            long b = z56.b(this);
            List<p0> k = k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : k) {
                b56 d = a66.d((p0) obj);
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
                c56 b2 = a66.b((p0) it.next());
                q46 a2 = b2 != null ? b2.a() : null;
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
            ArrayList<p0> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                c56 b3 = a66.b((p0) obj2);
                q46 a3 = b3 == null ? null : b3.a();
                if (a3 != null && a3.i().compareTo(ItemState.Measured) >= 0) {
                    arrayList2.add(obj2);
                }
            }
            boolean z5 = z3;
            for (p0 p0Var : arrayList2) {
                c56 b4 = a66.b(p0Var);
                q46 a4 = b4 == null ? null : b4.a();
                if (a4 != null) {
                    DrawState f2 = a4.f();
                    d56 e = a66.e(p0Var);
                    if (e != null || (e = (d56) z56.a(this, d56.class, p0Var, a4)) != null) {
                        d56 d56Var2 = e;
                        if (f2.e() != c.o()) {
                            f2.H(z);
                            d56Var = d56Var2;
                            drawState = f2;
                            d56Var.e(o().d(a4, b, n(), c));
                        } else {
                            d56Var = d56Var2;
                            drawState = f2;
                        }
                        if (d56Var.d()) {
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
                        d56Var.c().set(drawState.g(), drawState.h());
                        z = false;
                    }
                }
            }
            if (z56.e(this)) {
                if (z5) {
                    this.l.n();
                } else {
                    c.H();
                    this.j = c.o();
                }
            }
            b66.a();
        }
    }
}
