package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vwb;
import com.baidu.tieba.xwb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class zwb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Deque<c>> a;

    /* loaded from: classes9.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xwb a;
        public final HashSet<Ssp.Pid> b;

        public a(xwb xwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xwbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xwbVar;
            this.b = new HashSet<>();
            for (xwb.c cVar : xwbVar.e) {
                for (xwb.b bVar : cVar.b) {
                    this.b.add(bVar.c);
                }
            }
        }

        @Override // com.baidu.tieba.zwb.c
        public Set<Ssp.Pid> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Set) invokeV.objValue;
        }

        @Override // com.baidu.tieba.zwb.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.d : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vwb a;
        public final HashSet<Ssp.Pid> b;

        public b(vwb vwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vwbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vwbVar;
            this.b = new HashSet<>();
            for (vwb.b bVar : vwbVar.b) {
                for (vwb.a aVar : bVar.b) {
                    this.b.add(aVar.c);
                }
            }
        }

        @Override // com.baidu.tieba.zwb.c
        public Set<Ssp.Pid> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (Set) invokeV.objValue;
        }

        @Override // com.baidu.tieba.zwb.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.c : invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        Set<Ssp.Pid> a();

        int b();
    }

    public zwb() {
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
        this.a = new HashMap<>();
    }

    public final Deque<c> a(String str) {
        InterceptResult invokeL;
        Deque<c> deque;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.a) {
                deque = this.a.get(str);
                if (deque == null) {
                    deque = new ArrayDeque<>();
                    this.a.put(str, deque);
                }
            }
            return deque;
        }
        return (Deque) invokeL.objValue;
    }
}
