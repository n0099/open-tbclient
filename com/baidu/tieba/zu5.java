package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.ev5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class zu5 implements yu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, av5> a;
    public final ViewGroup b;
    public final hv5 c;
    public final ev5 d;
    public ViewType e;
    public av5 f;

    public zu5(hv5 hv5Var, @NonNull ViewGroup viewGroup, @NonNull ev5 ev5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hv5Var, viewGroup, ev5Var};
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
        this.c = hv5Var;
        this.d = ev5Var;
    }

    @Override // com.baidu.tieba.yu5
    public void a(ViewType viewType, String str) {
        ev5.a aVar;
        ev5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.yu5
    public void c(ViewType viewType, @NonNull av5 av5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, av5Var) == null) {
            this.a.put(viewType, av5Var);
        }
    }

    @Override // com.baidu.tieba.yu5
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
        hv5 hv5Var = this.c;
        if (hv5Var != null && hv5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        av5 av5Var = this.f;
        if (av5Var != null) {
            av5Var.b(this.b);
        }
        av5 av5Var2 = this.a.get(viewType);
        ev5.e d = d(viewType);
        if (av5Var2 != null && d != null) {
            av5Var2.c(viewType, this.b, d);
            this.f = av5Var2;
            this.a.put(viewType, av5Var2);
        }
    }

    public final ev5.e d(ViewType viewType) {
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
        return (ev5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yu5
    public void onChangeSkinType(int i) {
        av5 av5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (av5Var = this.f) != null) {
            av5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.yu5
    public void onDestroy() {
        av5 av5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (av5Var = this.f) != null) {
            av5Var.b(this.b);
        }
    }
}
