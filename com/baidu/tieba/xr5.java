package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.cs5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class xr5 implements wr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, yr5> a;
    public final ViewGroup b;
    public final fs5 c;
    public final cs5 d;
    public ViewType e;
    public yr5 f;

    public xr5(fs5 fs5Var, @NonNull ViewGroup viewGroup, @NonNull cs5 cs5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs5Var, viewGroup, cs5Var};
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
        this.b = viewGroup;
        this.c = fs5Var;
        this.d = cs5Var;
    }

    @Override // com.baidu.tieba.wr5
    public void a(ViewType viewType, String str) {
        cs5.a aVar;
        cs5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.wr5
    public void c(ViewType viewType, @NonNull yr5 yr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, yr5Var) == null) {
            this.a.put(viewType, yr5Var);
        }
    }

    @Override // com.baidu.tieba.wr5
    public void b(ViewType viewType) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) != null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        fs5 fs5Var = this.c;
        if (fs5Var != null && fs5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        yr5 yr5Var = this.f;
        if (yr5Var != null) {
            yr5Var.b(this.b);
        }
        yr5 yr5Var2 = this.a.get(viewType);
        cs5.e d = d(viewType);
        if (yr5Var2 != null && d != null) {
            yr5Var2.c(viewType, this.b, d);
            this.f = yr5Var2;
            this.a.put(viewType, yr5Var2);
        }
    }

    public final cs5.e d(ViewType viewType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewType)) == null) {
            if (viewType == ViewType.ERROR) {
                return this.d.c;
            }
            if (viewType == ViewType.EMPTY) {
                return this.d.b;
            }
            if (viewType == ViewType.LOADING) {
                return this.d.a;
            }
            return null;
        }
        return (cs5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wr5
    public void onChangeSkinType(int i) {
        yr5 yr5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (yr5Var = this.f) != null) {
            yr5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.wr5
    public void onDestroy() {
        yr5 yr5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (yr5Var = this.f) != null) {
            yr5Var.b(this.b);
        }
    }
}
