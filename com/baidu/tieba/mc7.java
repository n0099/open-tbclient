package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class mc7 implements gc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public pk1<gc7> a;

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nk1 b = nk1.b();
            this.a = b;
            b.a(new hc7());
        }
    }

    public mc7() {
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
        b();
    }

    @Override // com.baidu.tieba.gc7
    @NonNull
    public List<oc7<?, ?>> a() {
        InterceptResult invokeV;
        List<gc7> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            pk1<gc7> pk1Var = this.a;
            if (pk1Var == null) {
                list = null;
            } else {
                list = pk1Var.getList();
            }
            if (list != null) {
                for (gc7 gc7Var : list) {
                    arrayList.addAll(gc7Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
