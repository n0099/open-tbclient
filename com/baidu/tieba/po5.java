package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.uo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class po5 implements oo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, qo5> a;
    public final ViewGroup b;
    public final xo5 c;
    public final uo5 d;
    public ViewType e;
    public qo5 f;

    public po5(xo5 xo5Var, @NonNull ViewGroup viewGroup, @NonNull uo5 uo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xo5Var, viewGroup, uo5Var};
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
        this.c = xo5Var;
        this.d = uo5Var;
    }

    @Override // com.baidu.tieba.oo5
    public void a(ViewType viewType, String str) {
        uo5.a aVar;
        uo5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.oo5
    public void c(ViewType viewType, @NonNull qo5 qo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, qo5Var) == null) {
            this.a.put(viewType, qo5Var);
        }
    }

    @Override // com.baidu.tieba.oo5
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
        xo5 xo5Var = this.c;
        if (xo5Var != null && xo5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        qo5 qo5Var = this.f;
        if (qo5Var != null) {
            qo5Var.b(this.b);
        }
        qo5 qo5Var2 = this.a.get(viewType);
        uo5.e d = d(viewType);
        if (qo5Var2 != null && d != null) {
            qo5Var2.c(viewType, this.b, d);
            this.f = qo5Var2;
            this.a.put(viewType, qo5Var2);
        }
    }

    public final uo5.e d(ViewType viewType) {
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
        return (uo5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.oo5
    public void onChangeSkinType(int i) {
        qo5 qo5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (qo5Var = this.f) != null) {
            qo5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.oo5
    public void onDestroy() {
        qo5 qo5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (qo5Var = this.f) != null) {
            qo5Var.b(this.b);
        }
    }
}
