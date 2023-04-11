package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.xo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class so5 implements ro5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, to5> a;
    public final ViewGroup b;
    public final ap5 c;
    public final xo5 d;
    public ViewType e;
    public to5 f;

    public so5(ap5 ap5Var, @NonNull ViewGroup viewGroup, @NonNull xo5 xo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap5Var, viewGroup, xo5Var};
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
        this.c = ap5Var;
        this.d = xo5Var;
    }

    @Override // com.baidu.tieba.ro5
    public void a(ViewType viewType, String str) {
        xo5.a aVar;
        xo5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.ro5
    public void c(ViewType viewType, @NonNull to5 to5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, to5Var) == null) {
            this.a.put(viewType, to5Var);
        }
    }

    @Override // com.baidu.tieba.ro5
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
        ap5 ap5Var = this.c;
        if (ap5Var != null && ap5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        to5 to5Var = this.f;
        if (to5Var != null) {
            to5Var.b(this.b);
        }
        to5 to5Var2 = this.a.get(viewType);
        xo5.e d = d(viewType);
        if (to5Var2 != null && d != null) {
            to5Var2.c(viewType, this.b, d);
            this.f = to5Var2;
            this.a.put(viewType, to5Var2);
        }
    }

    public final xo5.e d(ViewType viewType) {
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
        return (xo5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ro5
    public void onChangeSkinType(int i) {
        to5 to5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (to5Var = this.f) != null) {
            to5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.ro5
    public void onDestroy() {
        to5 to5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (to5Var = this.f) != null) {
            to5Var.b(this.b);
        }
    }
}
