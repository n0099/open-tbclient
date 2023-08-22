package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public class ua2 implements ta2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ta2> a;

    public ua2() {
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

    @Override // com.baidu.tieba.ta2
    public void a() {
        List<ta2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ta2 ta2Var : this.a) {
                ta2Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.ta2
    public void b() {
        List<ta2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ta2 ta2Var : this.a) {
                ta2Var.b();
            }
        }
    }

    @Override // com.baidu.tieba.ta2
    public void c() {
        List<ta2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (list = this.a) != null && list.size() > 0) {
            for (ta2 ta2Var : this.a) {
                ta2Var.c();
            }
        }
    }

    public void d(@NonNull ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ta2Var) == null) {
            this.a.add(ta2Var);
        }
    }

    public void e(@NonNull ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ta2Var) == null) {
            this.a.remove(ta2Var);
        }
    }
}
