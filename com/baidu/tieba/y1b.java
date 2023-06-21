package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u1b;
import com.baidu.tieba.w1b;
import com.baidu.tieba.y1b;
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
/* loaded from: classes8.dex */
public class y1b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f1b a;
    public final u1b b;
    public final HashMap<String, w1b> c;

    /* loaded from: classes8.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes8.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public y1b() {
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
        this.b = new u1b();
        this.c = new HashMap<>();
    }

    public synchronized void a(f1b f1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, f1bVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                f1b f1bVar2 = this.a;
                if (f1bVar2 != null) {
                    for (s1b s1bVar : f1bVar2.b) {
                        hashSet.add(s1bVar.a);
                    }
                    for (q1b q1bVar : this.a.c) {
                        hashSet.add(q1bVar.a);
                    }
                }
                f1b f1bVar3 = this.a;
                Set<q1b> set = null;
                b(f1bVar3 == null ? null : f1bVar3.b, f1bVar.b, new a(this, hashSet));
                f1b f1bVar4 = this.a;
                if (f1bVar4 != null) {
                    set = f1bVar4.c;
                }
                b(set, f1bVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = f1bVar;
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

    /* loaded from: classes8.dex */
    public class a implements d<s1b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ y1b b;

        public a(y1b y1bVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y1bVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y1bVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(s1b s1bVar, y7b y7bVar) {
            return new t7b(s1bVar, y7bVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.y1b.d
        public void a(s1b s1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s1bVar) == null) {
                s1b s1bVar2 = s1bVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", s1bVar2.a);
                this.a.remove(s1bVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y1b.d
        /* renamed from: c */
        public void b(final s1b s1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s1bVar) == null) {
                LogPrinter.v("Update SlotId:%s", s1bVar.a);
                HashMap<String, w1b> hashMap = this.b.c;
                String str = s1bVar.a;
                hashMap.put(str, new w1b(str, new w1b.a() { // from class: com.baidu.tieba.x0b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.w1b.a
                    public final FunAdLoader a(y7b y7bVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, y7bVar)) == null) ? y1b.a.a(s1b.this, y7bVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                u1b u1bVar = this.b.b;
                synchronized (u1bVar.a) {
                    u1bVar.a(s1bVar.a).add(new u1b.a(s1bVar));
                }
                this.a.remove(s1bVar.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d<q1b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ y1b b;

        public b(y1b y1bVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y1bVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y1bVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(q1b q1bVar, y7b y7bVar) {
            return new u7b(q1bVar, y7bVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.y1b.d
        public void a(q1b q1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q1bVar) == null) {
                q1b q1bVar2 = q1bVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", q1bVar2.a);
                this.a.remove(q1bVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y1b.d
        /* renamed from: c */
        public void b(final q1b q1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q1bVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", q1bVar.a);
                HashMap<String, w1b> hashMap = this.b.c;
                String str = q1bVar.a;
                hashMap.put(str, new w1b(str, new w1b.a() { // from class: com.baidu.tieba.v0b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.w1b.a
                    public final FunAdLoader a(y7b y7bVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, y7bVar)) == null) ? y1b.b.a(q1b.this, y7bVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                u1b u1bVar = this.b.b;
                synchronized (u1bVar.a) {
                    u1bVar.a(q1bVar.a).add(new u1b.b(q1bVar));
                }
                this.a.remove(q1bVar.a);
            }
        }
    }
}
