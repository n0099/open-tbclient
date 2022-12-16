package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l78 a;
    public BaseFragmentActivity b;
    public int c;

    public o78(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 3;
        this.b = baseFragmentActivity;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.c != i) {
            l78 l78Var = this.a;
            if (l78Var != null) {
                l78Var.o();
            }
            this.c = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        l78 l78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdTypeListView) == null) && (l78Var = this.a) != null) {
            bdTypeListView.removeHeaderView(l78Var.a);
        }
    }

    public final void a(h08 h08Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, h08Var, str) != null) || h08Var == null) {
            return;
        }
        if (this.a == null) {
            this.a = new l78(LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06f1, (ViewGroup) null));
        }
        this.a.m(h08Var, str);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            l78 l78Var = this.a;
            if (l78Var == null) {
                return null;
            }
            return l78Var.a;
        }
        return (View) invokeV.objValue;
    }

    public void d(h08 h08Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, h08Var, str) == null) && h08Var != null && h08Var.Q() != null) {
            a(h08Var, str);
        }
    }
}
