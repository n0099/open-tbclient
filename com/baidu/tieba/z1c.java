package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v1c;
import com.baidu.tieba.x1c;
import com.baidu.tieba.z1c;
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
/* loaded from: classes9.dex */
public class z1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g1c a;
    public final v1c b;
    public final HashMap<String, x1c> c;

    /* loaded from: classes9.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes9.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public z1c() {
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
        this.b = new v1c();
        this.c = new HashMap<>();
    }

    public synchronized void a(g1c g1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g1cVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                g1c g1cVar2 = this.a;
                if (g1cVar2 != null) {
                    for (t1c t1cVar : g1cVar2.b) {
                        hashSet.add(t1cVar.a);
                    }
                    for (r1c r1cVar : this.a.c) {
                        hashSet.add(r1cVar.a);
                    }
                }
                g1c g1cVar3 = this.a;
                Set<r1c> set = null;
                b(g1cVar3 == null ? null : g1cVar3.b, g1cVar.b, new a(this, hashSet));
                g1c g1cVar4 = this.a;
                if (g1cVar4 != null) {
                    set = g1cVar4.c;
                }
                b(set, g1cVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = g1cVar;
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

    /* loaded from: classes9.dex */
    public class a implements d<t1c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ z1c b;

        public a(z1c z1cVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z1cVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z1cVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(t1c t1cVar, q7c q7cVar) {
            return new m7c(t1cVar, q7cVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.z1c.d
        public void a(t1c t1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t1cVar) == null) {
                t1c t1cVar2 = t1cVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", t1cVar2.a);
                this.a.remove(t1cVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z1c.d
        public void b(final t1c t1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t1cVar) == null) {
                LogPrinter.v("Update SlotId:%s", t1cVar.a);
                HashMap<String, x1c> hashMap = this.b.c;
                String str = t1cVar.a;
                hashMap.put(str, new x1c(str, new x1c.a() { // from class: com.baidu.tieba.y0c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.x1c.a
                    public final FunAdLoader a(q7c q7cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, q7cVar)) == null) ? z1c.a.a(t1c.this, q7cVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                v1c v1cVar = this.b.b;
                synchronized (v1cVar.a) {
                    v1cVar.a(t1cVar.a).add(new v1c.a(t1cVar));
                }
                this.a.remove(t1cVar.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d<r1c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ z1c b;

        public b(z1c z1cVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z1cVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z1cVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(r1c r1cVar, q7c q7cVar) {
            return new com.fun.t(r1cVar, q7cVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.z1c.d
        public void a(r1c r1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r1cVar) == null) {
                r1c r1cVar2 = r1cVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", r1cVar2.a);
                this.a.remove(r1cVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z1c.d
        public void b(final r1c r1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r1cVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", r1cVar.a);
                HashMap<String, x1c> hashMap = this.b.c;
                String str = r1cVar.a;
                hashMap.put(str, new x1c(str, new x1c.a() { // from class: com.baidu.tieba.w0c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.x1c.a
                    public final FunAdLoader a(q7c q7cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, q7cVar)) == null) ? z1c.b.a(r1c.this, q7cVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                v1c v1cVar = this.b.b;
                synchronized (v1cVar.a) {
                    v1cVar.a(r1cVar.a).add(new v1c.b(r1cVar));
                }
                this.a.remove(r1cVar.a);
            }
        }
    }
}
