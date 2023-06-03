package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.cv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class xu5 implements wu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, yu5> a;
    public final ViewGroup b;
    public final fv5 c;
    public final cv5 d;
    public ViewType e;
    public yu5 f;

    public xu5(fv5 fv5Var, @NonNull ViewGroup viewGroup, @NonNull cv5 cv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fv5Var, viewGroup, cv5Var};
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
        this.c = fv5Var;
        this.d = cv5Var;
    }

    @Override // com.baidu.tieba.wu5
    public void a(ViewType viewType, String str) {
        cv5.a aVar;
        cv5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.wu5
    public void c(ViewType viewType, @NonNull yu5 yu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, yu5Var) == null) {
            this.a.put(viewType, yu5Var);
        }
    }

    @Override // com.baidu.tieba.wu5
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
        fv5 fv5Var = this.c;
        if (fv5Var != null && fv5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        yu5 yu5Var = this.f;
        if (yu5Var != null) {
            yu5Var.b(this.b);
        }
        yu5 yu5Var2 = this.a.get(viewType);
        cv5.e d = d(viewType);
        if (yu5Var2 != null && d != null) {
            yu5Var2.c(viewType, this.b, d);
            this.f = yu5Var2;
            this.a.put(viewType, yu5Var2);
        }
    }

    public final cv5.e d(ViewType viewType) {
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
        return (cv5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wu5
    public void onChangeSkinType(int i) {
        yu5 yu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (yu5Var = this.f) != null) {
            yu5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.wu5
    public void onDestroy() {
        yu5 yu5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (yu5Var = this.f) != null) {
            yu5Var.b(this.b);
        }
    }
}
