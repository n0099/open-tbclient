package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class mb2 implements lb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<lb2> a;

    public mb2() {
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
        this.a = new CopyOnWriteArrayList();
    }

    @Override // com.baidu.tieba.lb2
    public void a() {
        List<lb2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (lb2 lb2Var : this.a) {
                lb2Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.lb2
    public void b() {
        List<lb2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (lb2 lb2Var : this.a) {
                lb2Var.b();
            }
        }
    }

    @Override // com.baidu.tieba.lb2
    public void c() {
        List<lb2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (lb2 lb2Var : this.a) {
                lb2Var.c();
            }
        }
    }

    public void d(@NonNull lb2 lb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lb2Var) == null) {
            this.a.add(lb2Var);
        }
    }

    public void e(@NonNull lb2 lb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lb2Var) == null) {
            this.a.remove(lb2Var);
        }
    }
}
