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
/* loaded from: classes6.dex */
public class sp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pp8 a;
    public BaseFragmentActivity b;
    public int c;

    public sp8(BaseFragmentActivity baseFragmentActivity) {
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
            pp8 pp8Var = this.a;
            if (pp8Var != null) {
                pp8Var.o();
            }
            this.c = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        pp8 pp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdTypeListView) == null) && (pp8Var = this.a) != null) {
            bdTypeListView.removeHeaderView(pp8Var.a);
        }
    }

    public final void a(ki8 ki8Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, ki8Var, str) != null) || ki8Var == null) {
            return;
        }
        if (this.a == null) {
            this.a = new pp8(LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0721, (ViewGroup) null));
        }
        this.a.m(ki8Var, str);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            pp8 pp8Var = this.a;
            if (pp8Var == null) {
                return null;
            }
            return pp8Var.a;
        }
        return (View) invokeV.objValue;
    }

    public void d(ki8 ki8Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ki8Var, str) == null) && ki8Var != null && ki8Var.Q() != null) {
            a(ki8Var, str);
        }
    }
}
