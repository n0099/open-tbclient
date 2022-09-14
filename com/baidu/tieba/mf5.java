package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.rf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class mf5 implements lf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, nf5> a;
    public final ViewGroup b;
    public final uf5 c;
    public final rf5 d;
    public ViewType e;
    public nf5 f;

    public mf5(uf5 uf5Var, @NonNull ViewGroup viewGroup, @NonNull rf5 rf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uf5Var, viewGroup, rf5Var};
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
        this.c = uf5Var;
        this.d = rf5Var;
    }

    @Override // com.baidu.tieba.lf5
    public void a(ViewType viewType, String str) {
        rf5.a aVar;
        rf5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType != ViewType.EMPTY || (aVar = this.d.b) == null) {
            } else {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.lf5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        uf5 uf5Var = this.c;
        if (uf5Var != null && uf5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        nf5 nf5Var = this.f;
        if (nf5Var != null) {
            nf5Var.b(this.b);
        }
        nf5 nf5Var2 = this.a.get(viewType);
        rf5.e d = d(viewType);
        if (nf5Var2 == null || d == null) {
            return;
        }
        nf5Var2.c(viewType, this.b, d);
        this.f = nf5Var2;
        this.a.put(viewType, nf5Var2);
    }

    @Override // com.baidu.tieba.lf5
    public void c(ViewType viewType, @NonNull nf5 nf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, nf5Var) == null) {
            this.a.put(viewType, nf5Var);
        }
    }

    public final rf5.e d(ViewType viewType) {
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
        return (rf5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lf5
    public void onChangeSkinType(int i) {
        nf5 nf5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (nf5Var = this.f) == null) {
            return;
        }
        nf5Var.e(i);
    }

    @Override // com.baidu.tieba.lf5
    public void onDestroy() {
        nf5 nf5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (nf5Var = this.f) == null) {
            return;
        }
        nf5Var.b(this.b);
    }
}
