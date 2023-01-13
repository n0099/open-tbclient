package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.vi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class qi5 implements pi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, ri5> a;
    public final ViewGroup b;
    public final yi5 c;
    public final vi5 d;
    public ViewType e;
    public ri5 f;

    public qi5(yi5 yi5Var, @NonNull ViewGroup viewGroup, @NonNull vi5 vi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yi5Var, viewGroup, vi5Var};
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
        this.c = yi5Var;
        this.d = vi5Var;
    }

    @Override // com.baidu.tieba.pi5
    public void a(ViewType viewType, String str) {
        vi5.a aVar;
        vi5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.pi5
    public void c(ViewType viewType, @NonNull ri5 ri5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, ri5Var) == null) {
            this.a.put(viewType, ri5Var);
        }
    }

    @Override // com.baidu.tieba.pi5
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
        yi5 yi5Var = this.c;
        if (yi5Var != null && yi5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        ri5 ri5Var = this.f;
        if (ri5Var != null) {
            ri5Var.b(this.b);
        }
        ri5 ri5Var2 = this.a.get(viewType);
        vi5.e d = d(viewType);
        if (ri5Var2 != null && d != null) {
            ri5Var2.c(viewType, this.b, d);
            this.f = ri5Var2;
            this.a.put(viewType, ri5Var2);
        }
    }

    public final vi5.e d(ViewType viewType) {
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
        return (vi5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pi5
    public void onChangeSkinType(int i) {
        ri5 ri5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (ri5Var = this.f) != null) {
            ri5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.pi5
    public void onDestroy() {
        ri5 ri5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (ri5Var = this.f) != null) {
            ri5Var.b(this.b);
        }
    }
}
