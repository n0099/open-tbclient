package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.meb;
import com.baidu.tieba.oeb;
import com.baidu.tieba.qeb;
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
public class qeb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xdb a;
    public final meb b;
    public final HashMap<String, oeb> c;

    /* loaded from: classes7.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes7.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public qeb() {
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
        this.b = new meb();
        this.c = new HashMap<>();
    }

    public synchronized void a(xdb xdbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xdbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                xdb xdbVar2 = this.a;
                if (xdbVar2 != null) {
                    for (keb kebVar : xdbVar2.b) {
                        hashSet.add(kebVar.a);
                    }
                    for (ieb iebVar : this.a.c) {
                        hashSet.add(iebVar.a);
                    }
                }
                xdb xdbVar3 = this.a;
                Set<ieb> set = null;
                b(xdbVar3 == null ? null : xdbVar3.b, xdbVar.b, new a(this, hashSet));
                xdb xdbVar4 = this.a;
                if (xdbVar4 != null) {
                    set = xdbVar4.c;
                }
                b(set, xdbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = xdbVar;
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
    public class a implements d<keb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ qeb b;

        public a(qeb qebVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qebVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qebVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(keb kebVar, pkb pkbVar) {
            return new lkb(kebVar, pkbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.qeb.d
        public void a(keb kebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kebVar) == null) {
                keb kebVar2 = kebVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", kebVar2.a);
                this.a.remove(kebVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qeb.d
        /* renamed from: c */
        public void b(final keb kebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kebVar) == null) {
                LogPrinter.v("Update SlotId:%s", kebVar.a);
                HashMap<String, oeb> hashMap = this.b.c;
                String str = kebVar.a;
                hashMap.put(str, new oeb(str, new oeb.a() { // from class: com.baidu.tieba.pdb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.oeb.a
                    public final FunAdLoader a(pkb pkbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, pkbVar)) == null) ? qeb.a.a(keb.this, pkbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                meb mebVar = this.b.b;
                synchronized (mebVar.a) {
                    mebVar.a(kebVar.a).add(new meb.a(kebVar));
                }
                this.a.remove(kebVar.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d<ieb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ qeb b;

        public b(qeb qebVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qebVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qebVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(ieb iebVar, pkb pkbVar) {
            return new com.fun.t(iebVar, pkbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.qeb.d
        public void a(ieb iebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iebVar) == null) {
                ieb iebVar2 = iebVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", iebVar2.a);
                this.a.remove(iebVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qeb.d
        /* renamed from: c */
        public void b(final ieb iebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iebVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", iebVar.a);
                HashMap<String, oeb> hashMap = this.b.c;
                String str = iebVar.a;
                hashMap.put(str, new oeb(str, new oeb.a() { // from class: com.baidu.tieba.ndb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.oeb.a
                    public final FunAdLoader a(pkb pkbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, pkbVar)) == null) ? qeb.b.a(ieb.this, pkbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                meb mebVar = this.b.b;
                synchronized (mebVar.a) {
                    mebVar.a(iebVar.a).add(new meb.b(iebVar));
                }
                this.a.remove(iebVar.a);
            }
        }
    }
}
