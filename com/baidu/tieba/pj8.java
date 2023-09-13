package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes7.dex */
public class pj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MetaData> a;
    public List<MetaData> b;
    public List<MetaData> c;
    public List<MetaData> d;

    /* loaded from: classes7.dex */
    public class a implements Comparator<MetaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(pj8 pj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MetaData metaData, MetaData metaData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, metaData, metaData2)) == null) {
                return Long.compare(metaData.lastUpdateTime, metaData2.lastUpdateTime);
            }
            return invokeLL.intValue;
        }
    }

    public pj8() {
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
        this.d = new ArrayList();
    }

    public List<MetaData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return c(true, true);
        }
        return (List) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Collections.sort(this.d, new a(this));
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!i39.e(this.a)) {
                for (MetaData metaData : this.a) {
                    metaData.setItemType(1);
                }
            }
            if (!i39.e(this.c)) {
                for (MetaData metaData2 : this.c) {
                    metaData2.setItemType(2);
                }
            }
            if (!i39.e(this.b)) {
                for (MetaData metaData3 : this.b) {
                    metaData3.setItemType(3);
                }
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ArrayList arrayList = new ArrayList();
            for (MetaData metaData : this.a) {
                if (metaData != null) {
                    arrayList.add(metaData.getUserId());
                }
            }
            if (i39.e(this.c)) {
                return;
            }
            for (MetaData metaData2 : this.c) {
                if (metaData2 != null) {
                    if (metaData2.getUserId() == null) {
                        this.d.add(metaData2);
                    } else if (!arrayList.contains(metaData2.getUserId())) {
                        arrayList.add(metaData2.getUserId());
                        this.d.add(metaData2);
                    }
                }
            }
        }
    }

    public List<MetaData> c(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return d(z, z2, true);
        }
        return (List) invokeCommon.objValue;
    }

    public List<MetaData> d(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            this.a = qj8.a();
            if (z) {
                this.b = rj8.a();
            }
            a();
            f(z, z3);
            g();
            if (z2) {
                this.c = tj8.a();
                e();
            }
            return this.d;
        }
        return (List) invokeCommon.objValue;
    }

    public final void f(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2 && !i39.e(this.a)) {
                this.d.addAll(this.a);
            }
            if (z && !i39.e(this.b)) {
                this.d.addAll(this.b);
            }
        }
    }
}
