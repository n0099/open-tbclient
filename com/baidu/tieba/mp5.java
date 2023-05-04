package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.rp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class mp5 implements lp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, np5> a;
    public final ViewGroup b;
    public final up5 c;
    public final rp5 d;
    public ViewType e;
    public np5 f;

    public mp5(up5 up5Var, @NonNull ViewGroup viewGroup, @NonNull rp5 rp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {up5Var, viewGroup, rp5Var};
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
        this.c = up5Var;
        this.d = rp5Var;
    }

    @Override // com.baidu.tieba.lp5
    public void a(ViewType viewType, String str) {
        rp5.a aVar;
        rp5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.lp5
    public void c(ViewType viewType, @NonNull np5 np5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, np5Var) == null) {
            this.a.put(viewType, np5Var);
        }
    }

    @Override // com.baidu.tieba.lp5
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
        up5 up5Var = this.c;
        if (up5Var != null && up5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        np5 np5Var = this.f;
        if (np5Var != null) {
            np5Var.b(this.b);
        }
        np5 np5Var2 = this.a.get(viewType);
        rp5.e d = d(viewType);
        if (np5Var2 != null && d != null) {
            np5Var2.c(viewType, this.b, d);
            this.f = np5Var2;
            this.a.put(viewType, np5Var2);
        }
    }

    public final rp5.e d(ViewType viewType) {
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
        return (rp5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lp5
    public void onChangeSkinType(int i) {
        np5 np5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (np5Var = this.f) != null) {
            np5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.lp5
    public void onDestroy() {
        np5 np5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (np5Var = this.f) != null) {
            np5Var.b(this.b);
        }
    }
}
