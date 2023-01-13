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
/* loaded from: classes5.dex */
public class mj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MetaData> a;
    public List<MetaData> b;
    public List<MetaData> c;
    public List<MetaData> d;

    /* loaded from: classes5.dex */
    public class a implements Comparator<MetaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(mj7 mj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj7Var};
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

    public mj7() {
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Collections.sort(this.d, new a(this));
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!uq7.e(this.a)) {
                for (MetaData metaData : this.a) {
                    metaData.setItemType(1);
                }
            }
            if (!uq7.e(this.c)) {
                for (MetaData metaData2 : this.c) {
                    metaData2.setItemType(2);
                }
            }
            if (!uq7.e(this.b)) {
                for (MetaData metaData3 : this.b) {
                    metaData3.setItemType(3);
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList();
            for (MetaData metaData : this.a) {
                if (metaData != null) {
                    arrayList.add(metaData.getUserId());
                }
            }
            if (uq7.e(this.c)) {
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
            this.a = nj7.a();
            if (z) {
                this.b = oj7.a();
            }
            a();
            e(z);
            f();
            if (z2) {
                this.c = qj7.a();
                d();
            }
            return this.d;
        }
        return (List) invokeCommon.objValue;
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (!uq7.e(this.a)) {
                this.d.addAll(this.a);
            }
            if (z && !uq7.e(this.b)) {
                this.d.addAll(this.b);
            }
        }
    }
}
