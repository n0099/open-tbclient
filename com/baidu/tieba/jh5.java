package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.oh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class jh5 implements ih5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, kh5> a;
    public final ViewGroup b;
    public final rh5 c;
    public final oh5 d;
    public ViewType e;
    public kh5 f;

    public jh5(rh5 rh5Var, @NonNull ViewGroup viewGroup, @NonNull oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rh5Var, viewGroup, oh5Var};
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
        this.c = rh5Var;
        this.d = oh5Var;
    }

    @Override // com.baidu.tieba.ih5
    public void a(ViewType viewType, String str) {
        oh5.a aVar;
        oh5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.ih5
    public void c(ViewType viewType, @NonNull kh5 kh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, kh5Var) == null) {
            this.a.put(viewType, kh5Var);
        }
    }

    @Override // com.baidu.tieba.ih5
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
        rh5 rh5Var = this.c;
        if (rh5Var != null && rh5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        kh5 kh5Var = this.f;
        if (kh5Var != null) {
            kh5Var.b(this.b);
        }
        kh5 kh5Var2 = this.a.get(viewType);
        oh5.e d = d(viewType);
        if (kh5Var2 != null && d != null) {
            kh5Var2.c(viewType, this.b, d);
            this.f = kh5Var2;
            this.a.put(viewType, kh5Var2);
        }
    }

    public final oh5.e d(ViewType viewType) {
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
        return (oh5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ih5
    public void onChangeSkinType(int i) {
        kh5 kh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (kh5Var = this.f) != null) {
            kh5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.ih5
    public void onDestroy() {
        kh5 kh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (kh5Var = this.f) != null) {
            kh5Var.b(this.b);
        }
    }
}
