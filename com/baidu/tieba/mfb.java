package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ifb;
import com.baidu.tieba.kfb;
import com.baidu.tieba.mfb;
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
public class mfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public teb a;
    public final ifb b;
    public final HashMap<String, kfb> c;

    /* loaded from: classes7.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes7.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public mfb() {
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
        this.b = new ifb();
        this.c = new HashMap<>();
    }

    public synchronized void a(teb tebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tebVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                teb tebVar2 = this.a;
                if (tebVar2 != null) {
                    for (gfb gfbVar : tebVar2.b) {
                        hashSet.add(gfbVar.a);
                    }
                    for (efb efbVar : this.a.c) {
                        hashSet.add(efbVar.a);
                    }
                }
                teb tebVar3 = this.a;
                Set<efb> set = null;
                b(tebVar3 == null ? null : tebVar3.b, tebVar.b, new a(this, hashSet));
                teb tebVar4 = this.a;
                if (tebVar4 != null) {
                    set = tebVar4.c;
                }
                b(set, tebVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = tebVar;
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
    public class a implements d<gfb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ mfb b;

        public a(mfb mfbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mfbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mfbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(gfb gfbVar, llb llbVar) {
            return new hlb(gfbVar, llbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.mfb.d
        public void a(gfb gfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gfbVar) == null) {
                gfb gfbVar2 = gfbVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", gfbVar2.a);
                this.a.remove(gfbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mfb.d
        /* renamed from: c */
        public void b(final gfb gfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gfbVar) == null) {
                LogPrinter.v("Update SlotId:%s", gfbVar.a);
                HashMap<String, kfb> hashMap = this.b.c;
                String str = gfbVar.a;
                hashMap.put(str, new kfb(str, new kfb.a() { // from class: com.baidu.tieba.leb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.kfb.a
                    public final FunAdLoader a(llb llbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, llbVar)) == null) ? mfb.a.a(gfb.this, llbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                ifb ifbVar = this.b.b;
                synchronized (ifbVar.a) {
                    ifbVar.a(gfbVar.a).add(new ifb.a(gfbVar));
                }
                this.a.remove(gfbVar.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d<efb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ mfb b;

        public b(mfb mfbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mfbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mfbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(efb efbVar, llb llbVar) {
            return new com.fun.t(efbVar, llbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.mfb.d
        public void a(efb efbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, efbVar) == null) {
                efb efbVar2 = efbVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", efbVar2.a);
                this.a.remove(efbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mfb.d
        /* renamed from: c */
        public void b(final efb efbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, efbVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", efbVar.a);
                HashMap<String, kfb> hashMap = this.b.c;
                String str = efbVar.a;
                hashMap.put(str, new kfb(str, new kfb.a() { // from class: com.baidu.tieba.jeb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.kfb.a
                    public final FunAdLoader a(llb llbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, llbVar)) == null) ? mfb.b.a(efb.this, llbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                ifb ifbVar = this.b.b;
                synchronized (ifbVar.a) {
                    ifbVar.a(efbVar.a).add(new ifb.b(efbVar));
                }
                this.a.remove(efbVar.a);
            }
        }
    }
}
