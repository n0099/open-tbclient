package com.baidu.tieba;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class lg2 implements jg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<jg2> a;

    public lg2() {
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

    @Override // com.baidu.tieba.jg2
    public void a() {
        List<jg2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (jg2 jg2Var : this.a) {
            if (jg2Var != null) {
                jg2Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.jg2
    public void b() {
        List<jg2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (jg2 jg2Var : this.a) {
            jg2Var.b();
        }
    }

    @Override // com.baidu.tieba.jg2
    public void c() {
        List<jg2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (jg2 jg2Var : this.a) {
            jg2Var.c();
        }
    }

    @Override // com.baidu.tieba.jg2
    public void d() {
        List<jg2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (jg2 jg2Var : this.a) {
            jg2Var.d();
        }
    }

    @Override // com.baidu.tieba.jg2
    public void e() {
        List<jg2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (jg2 jg2Var : this.a) {
            jg2Var.e();
        }
    }

    @Override // com.baidu.tieba.jg2
    public void f() {
        List<jg2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (jg2 jg2Var : this.a) {
            jg2Var.f();
        }
    }

    @Override // com.baidu.tieba.jg2
    public void g() {
        List<jg2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (list = this.a) == null || list.size() <= 0) {
            return;
        }
        for (jg2 jg2Var : this.a) {
            jg2Var.g();
        }
    }

    public void h(@NonNull jg2 jg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jg2Var) == null) {
            this.a.add(jg2Var);
        }
    }

    public void i(@NonNull jg2 jg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jg2Var) == null) {
            this.a.remove(jg2Var);
        }
    }

    @Override // com.baidu.tieba.jg2
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            List<jg2> list = this.a;
            if (list == null || list.size() <= 0) {
                return false;
            }
            while (true) {
                for (jg2 jg2Var : this.a) {
                    z = z || jg2Var.onKeyDown(i, keyEvent);
                }
                return z;
            }
        }
        return invokeIL.booleanValue;
    }
}
