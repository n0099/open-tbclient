package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.leb;
import com.baidu.tieba.neb;
import com.baidu.tieba.peb;
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
public class peb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wdb a;
    public final leb b;
    public final HashMap<String, neb> c;

    /* loaded from: classes7.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes7.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public peb() {
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
        this.b = new leb();
        this.c = new HashMap<>();
    }

    public synchronized void a(wdb wdbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wdbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                wdb wdbVar2 = this.a;
                if (wdbVar2 != null) {
                    for (jeb jebVar : wdbVar2.b) {
                        hashSet.add(jebVar.a);
                    }
                    for (heb hebVar : this.a.c) {
                        hashSet.add(hebVar.a);
                    }
                }
                wdb wdbVar3 = this.a;
                Set<heb> set = null;
                b(wdbVar3 == null ? null : wdbVar3.b, wdbVar.b, new a(this, hashSet));
                wdb wdbVar4 = this.a;
                if (wdbVar4 != null) {
                    set = wdbVar4.c;
                }
                b(set, wdbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = wdbVar;
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
    public class a implements d<jeb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ peb b;

        public a(peb pebVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pebVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pebVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(jeb jebVar, okb okbVar) {
            return new kkb(jebVar, okbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.peb.d
        public void a(jeb jebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jebVar) == null) {
                jeb jebVar2 = jebVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", jebVar2.a);
                this.a.remove(jebVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.peb.d
        /* renamed from: c */
        public void b(final jeb jebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jebVar) == null) {
                LogPrinter.v("Update SlotId:%s", jebVar.a);
                HashMap<String, neb> hashMap = this.b.c;
                String str = jebVar.a;
                hashMap.put(str, new neb(str, new neb.a() { // from class: com.baidu.tieba.odb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.neb.a
                    public final FunAdLoader a(okb okbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, okbVar)) == null) ? peb.a.a(jeb.this, okbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                leb lebVar = this.b.b;
                synchronized (lebVar.a) {
                    lebVar.a(jebVar.a).add(new leb.a(jebVar));
                }
                this.a.remove(jebVar.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d<heb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ peb b;

        public b(peb pebVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pebVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pebVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(heb hebVar, okb okbVar) {
            return new com.fun.t(hebVar, okbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.peb.d
        public void a(heb hebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hebVar) == null) {
                heb hebVar2 = hebVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", hebVar2.a);
                this.a.remove(hebVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.peb.d
        /* renamed from: c */
        public void b(final heb hebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hebVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", hebVar.a);
                HashMap<String, neb> hashMap = this.b.c;
                String str = hebVar.a;
                hashMap.put(str, new neb(str, new neb.a() { // from class: com.baidu.tieba.mdb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.neb.a
                    public final FunAdLoader a(okb okbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, okbVar)) == null) ? peb.b.a(heb.this, okbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                leb lebVar = this.b.b;
                synchronized (lebVar.a) {
                    lebVar.a(hebVar.a).add(new leb.b(hebVar));
                }
                this.a.remove(hebVar.a);
            }
        }
    }
}
