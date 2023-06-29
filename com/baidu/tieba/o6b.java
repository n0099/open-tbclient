package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k6b;
import com.baidu.tieba.m6b;
import com.baidu.tieba.o6b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes7.dex */
public class o6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v5b a;
    public final k6b b;
    public final HashMap<String, m6b> c;

    /* loaded from: classes7.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes7.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public o6b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new k6b();
        this.c = new HashMap<>();
    }

    public synchronized void a(v5b v5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v5bVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                v5b v5bVar2 = this.a;
                if (v5bVar2 != null) {
                    for (i6b i6bVar : v5bVar2.b) {
                        hashSet.add(i6bVar.a);
                    }
                    for (g6b g6bVar : this.a.c) {
                        hashSet.add(g6bVar.a);
                    }
                }
                v5b v5bVar3 = this.a;
                Set<g6b> set = null;
                b(v5bVar3 == null ? null : v5bVar3.b, v5bVar.b, new a(this, hashSet));
                v5b v5bVar4 = this.a;
                if (v5bVar4 != null) {
                    set = v5bVar4.c;
                }
                b(set, v5bVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = v5bVar;
            }
        }
    }

    public final <E> void b(Set<E> set, Set<E> set2, d<E> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set, set2, dVar) == null) {
            for (E e : set2) {
                if (set == null || !set.contains(e)) {
                    dVar.b(e);
                } else {
                    dVar.a(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements d<i6b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ o6b b;

        public a(o6b o6bVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o6bVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o6bVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(i6b i6bVar, ocb ocbVar) {
            return new jcb(i6bVar, ocbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.o6b.d
        public void a(i6b i6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i6bVar) == null) {
                i6b i6bVar2 = i6bVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", i6bVar2.a);
                this.a.remove(i6bVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o6b.d
        /* renamed from: c */
        public void b(final i6b i6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i6bVar) == null) {
                LogPrinter.v("Update SlotId:%s", i6bVar.a);
                HashMap<String, m6b> hashMap = this.b.c;
                String str = i6bVar.a;
                hashMap.put(str, new m6b(str, new m6b.a() { // from class: com.baidu.tieba.n5b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m6b.a
                    public final FunAdLoader a(ocb ocbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ocbVar)) == null) ? o6b.a.a(i6b.this, ocbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                k6b k6bVar = this.b.b;
                synchronized (k6bVar.a) {
                    k6bVar.a(i6bVar.a).add(new k6b.a(i6bVar));
                }
                this.a.remove(i6bVar.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d<g6b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ o6b b;

        public b(o6b o6bVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o6bVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o6bVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(g6b g6bVar, ocb ocbVar) {
            return new kcb(g6bVar, ocbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.o6b.d
        public void a(g6b g6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g6bVar) == null) {
                g6b g6bVar2 = g6bVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", g6bVar2.a);
                this.a.remove(g6bVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o6b.d
        /* renamed from: c */
        public void b(final g6b g6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g6bVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", g6bVar.a);
                HashMap<String, m6b> hashMap = this.b.c;
                String str = g6bVar.a;
                hashMap.put(str, new m6b(str, new m6b.a() { // from class: com.baidu.tieba.l5b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m6b.a
                    public final FunAdLoader a(ocb ocbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, ocbVar)) == null) ? o6b.b.a(g6b.this, ocbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                k6b k6bVar = this.b.b;
                synchronized (k6bVar.a) {
                    k6bVar.a(g6bVar.a).add(new k6b.b(g6bVar));
                }
                this.a.remove(g6bVar.a);
            }
        }
    }
}
