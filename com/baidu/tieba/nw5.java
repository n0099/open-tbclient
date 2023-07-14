package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.sw5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class nw5 implements mw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, ow5> a;
    public final ViewGroup b;
    public final vw5 c;
    public final sw5 d;
    public ViewType e;
    public ow5 f;

    public nw5(vw5 vw5Var, @NonNull ViewGroup viewGroup, @NonNull sw5 sw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vw5Var, viewGroup, sw5Var};
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
        this.c = vw5Var;
        this.d = sw5Var;
    }

    @Override // com.baidu.tieba.mw5
    public void a(ViewType viewType, String str) {
        sw5.a aVar;
        sw5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.mw5
    public void c(ViewType viewType, @NonNull ow5 ow5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, ow5Var) == null) {
            this.a.put(viewType, ow5Var);
        }
    }

    @Override // com.baidu.tieba.mw5
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
        vw5 vw5Var = this.c;
        if (vw5Var != null && vw5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        ow5 ow5Var = this.f;
        if (ow5Var != null) {
            ow5Var.b(this.b);
        }
        ow5 ow5Var2 = this.a.get(viewType);
        sw5.e d = d(viewType);
        if (ow5Var2 != null && d != null) {
            ow5Var2.c(viewType, this.b, d);
            this.f = ow5Var2;
            this.a.put(viewType, ow5Var2);
        }
    }

    public final sw5.e d(ViewType viewType) {
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
        return (sw5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mw5
    public void onChangeSkinType(int i) {
        ow5 ow5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (ow5Var = this.f) != null) {
            ow5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.mw5
    public void onDestroy() {
        ow5 ow5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ow5Var = this.f) != null) {
            ow5Var.b(this.b);
        }
    }
}
