package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.zp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class up5 implements tp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, vp5> a;
    public final ViewGroup b;
    public final cq5 c;
    public final zp5 d;
    public ViewType e;
    public vp5 f;

    public up5(cq5 cq5Var, @NonNull ViewGroup viewGroup, @NonNull zp5 zp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cq5Var, viewGroup, zp5Var};
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
        this.c = cq5Var;
        this.d = zp5Var;
    }

    @Override // com.baidu.tieba.tp5
    public void a(ViewType viewType, String str) {
        zp5.a aVar;
        zp5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.tp5
    public void c(ViewType viewType, @NonNull vp5 vp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, vp5Var) == null) {
            this.a.put(viewType, vp5Var);
        }
    }

    @Override // com.baidu.tieba.tp5
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
        cq5 cq5Var = this.c;
        if (cq5Var != null && cq5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        vp5 vp5Var = this.f;
        if (vp5Var != null) {
            vp5Var.b(this.b);
        }
        vp5 vp5Var2 = this.a.get(viewType);
        zp5.e d = d(viewType);
        if (vp5Var2 != null && d != null) {
            vp5Var2.c(viewType, this.b, d);
            this.f = vp5Var2;
            this.a.put(viewType, vp5Var2);
        }
    }

    public final zp5.e d(ViewType viewType) {
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
        return (zp5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tp5
    public void onChangeSkinType(int i) {
        vp5 vp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (vp5Var = this.f) != null) {
            vp5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.tp5
    public void onDestroy() {
        vp5 vp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (vp5Var = this.f) != null) {
            vp5Var.b(this.b);
        }
    }
}
