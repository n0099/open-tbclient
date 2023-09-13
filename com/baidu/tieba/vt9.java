package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class vt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeListView a;
    public tt9 b;

    public vt9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bdTypeListView;
        this.b = new tt9(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.b();
        }
    }

    public void c() {
        tt9 tt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (tt9Var = this.b) != null) {
            tt9Var.c();
        }
    }

    public void d() {
        tt9 tt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (tt9Var = this.b) != null) {
            tt9Var.d();
        }
    }

    public void f() {
        tt9 tt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (tt9Var = this.b) != null) {
            tt9Var.f();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.g();
        }
    }

    public void e(boolean z) {
        tt9 tt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (tt9Var = this.b) != null) {
            tt9Var.e(z);
        }
    }

    public void h(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a.setData(new ArrayList(list));
        }
    }

    public void i(boolean z) {
        tt9 tt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (tt9Var = this.b) != null) {
            tt9Var.h(z);
        }
    }
}
