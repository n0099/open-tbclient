package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.yu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class tu5 implements su5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, uu5> a;
    public final ViewGroup b;
    public final bv5 c;
    public final yu5 d;
    public ViewType e;
    public uu5 f;

    public tu5(bv5 bv5Var, @NonNull ViewGroup viewGroup, @NonNull yu5 yu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bv5Var, viewGroup, yu5Var};
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
        this.c = bv5Var;
        this.d = yu5Var;
    }

    @Override // com.baidu.tieba.su5
    public void a(ViewType viewType, String str) {
        yu5.a aVar;
        yu5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.su5
    public void c(ViewType viewType, @NonNull uu5 uu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, uu5Var) == null) {
            this.a.put(viewType, uu5Var);
        }
    }

    @Override // com.baidu.tieba.su5
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
        bv5 bv5Var = this.c;
        if (bv5Var != null && bv5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        uu5 uu5Var = this.f;
        if (uu5Var != null) {
            uu5Var.b(this.b);
        }
        uu5 uu5Var2 = this.a.get(viewType);
        yu5.e d = d(viewType);
        if (uu5Var2 != null && d != null) {
            uu5Var2.c(viewType, this.b, d);
            this.f = uu5Var2;
            this.a.put(viewType, uu5Var2);
        }
    }

    public final yu5.e d(ViewType viewType) {
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
        return (yu5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.su5
    public void onChangeSkinType(int i) {
        uu5 uu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (uu5Var = this.f) != null) {
            uu5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.su5
    public void onDestroy() {
        uu5 uu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (uu5Var = this.f) != null) {
            uu5Var.b(this.b);
        }
    }
}
