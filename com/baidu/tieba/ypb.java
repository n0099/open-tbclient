package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.upb;
import com.baidu.tieba.wpb;
import com.baidu.tieba.ypb;
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
public class ypb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fpb a;
    public final upb b;
    public final HashMap<String, wpb> c;

    /* loaded from: classes8.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes8.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public ypb() {
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
        this.b = new upb();
        this.c = new HashMap<>();
    }

    public synchronized void a(fpb fpbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fpbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                fpb fpbVar2 = this.a;
                if (fpbVar2 != null) {
                    for (spb spbVar : fpbVar2.b) {
                        hashSet.add(spbVar.a);
                    }
                    for (qpb qpbVar : this.a.c) {
                        hashSet.add(qpbVar.a);
                    }
                }
                fpb fpbVar3 = this.a;
                Set<qpb> set = null;
                b(fpbVar3 == null ? null : fpbVar3.b, fpbVar.b, new a(this, hashSet));
                fpb fpbVar4 = this.a;
                if (fpbVar4 != null) {
                    set = fpbVar4.c;
                }
                b(set, fpbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = fpbVar;
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
    public class a implements d<spb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ ypb b;

        public a(ypb ypbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ypbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ypbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(spb spbVar, xvb xvbVar) {
            return new tvb(spbVar, xvbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.ypb.d
        public void a(spb spbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spbVar) == null) {
                spb spbVar2 = spbVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", spbVar2.a);
                this.a.remove(spbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ypb.d
        /* renamed from: c */
        public void b(final spb spbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, spbVar) == null) {
                LogPrinter.v("Update SlotId:%s", spbVar.a);
                HashMap<String, wpb> hashMap = this.b.c;
                String str = spbVar.a;
                hashMap.put(str, new wpb(str, new wpb.a() { // from class: com.baidu.tieba.xob
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.wpb.a
                    public final FunAdLoader a(xvb xvbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, xvbVar)) == null) ? ypb.a.a(spb.this, xvbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                upb upbVar = this.b.b;
                synchronized (upbVar.a) {
                    upbVar.a(spbVar.a).add(new upb.a(spbVar));
                }
                this.a.remove(spbVar.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d<qpb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ ypb b;

        public b(ypb ypbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ypbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ypbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(qpb qpbVar, xvb xvbVar) {
            return new com.fun.t(qpbVar, xvbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.ypb.d
        public void a(qpb qpbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qpbVar) == null) {
                qpb qpbVar2 = qpbVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", qpbVar2.a);
                this.a.remove(qpbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ypb.d
        /* renamed from: c */
        public void b(final qpb qpbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qpbVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", qpbVar.a);
                HashMap<String, wpb> hashMap = this.b.c;
                String str = qpbVar.a;
                hashMap.put(str, new wpb(str, new wpb.a() { // from class: com.baidu.tieba.vob
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.wpb.a
                    public final FunAdLoader a(xvb xvbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, xvbVar)) == null) ? ypb.b.a(qpb.this, xvbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                upb upbVar = this.b.b;
                synchronized (upbVar.a) {
                    upbVar.a(qpbVar.a).add(new upb.b(qpbVar));
                }
                this.a.remove(qpbVar.a);
            }
        }
    }
}
