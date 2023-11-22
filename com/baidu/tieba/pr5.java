package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.ur5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class pr5 implements or5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, qr5> a;
    public final ViewGroup b;
    public final xr5 c;
    public final ur5 d;
    public ViewType e;
    public qr5 f;

    public pr5(xr5 xr5Var, @NonNull ViewGroup viewGroup, @NonNull ur5 ur5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xr5Var, viewGroup, ur5Var};
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
        this.c = xr5Var;
        this.d = ur5Var;
    }

    @Override // com.baidu.tieba.or5
    public void a(ViewType viewType, String str) {
        ur5.a aVar;
        ur5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.or5
    public void c(ViewType viewType, @NonNull qr5 qr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, qr5Var) == null) {
            this.a.put(viewType, qr5Var);
        }
    }

    @Override // com.baidu.tieba.or5
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
        xr5 xr5Var = this.c;
        if (xr5Var != null && xr5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        qr5 qr5Var = this.f;
        if (qr5Var != null) {
            qr5Var.b(this.b);
        }
        qr5 qr5Var2 = this.a.get(viewType);
        ur5.e d = d(viewType);
        if (qr5Var2 != null && d != null) {
            qr5Var2.c(viewType, this.b, d);
            this.f = qr5Var2;
            this.a.put(viewType, qr5Var2);
        }
    }

    public final ur5.e d(ViewType viewType) {
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
        return (ur5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.or5
    public void onChangeSkinType(int i) {
        qr5 qr5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (qr5Var = this.f) != null) {
            qr5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.or5
    public void onDestroy() {
        qr5 qr5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (qr5Var = this.f) != null) {
            qr5Var.b(this.b);
        }
    }
}
