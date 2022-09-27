package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.eg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class zf5 implements yf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, ag5> a;
    public final ViewGroup b;
    public final hg5 c;
    public final eg5 d;
    public ViewType e;
    public ag5 f;

    public zf5(hg5 hg5Var, @NonNull ViewGroup viewGroup, @NonNull eg5 eg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hg5Var, viewGroup, eg5Var};
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
        this.c = hg5Var;
        this.d = eg5Var;
    }

    @Override // com.baidu.tieba.yf5
    public void a(ViewType viewType, String str) {
        eg5.a aVar;
        eg5.b bVar;
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

    @Override // com.baidu.tieba.yf5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        hg5 hg5Var = this.c;
        if (hg5Var != null && hg5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        ag5 ag5Var = this.f;
        if (ag5Var != null) {
            ag5Var.b(this.b);
        }
        ag5 ag5Var2 = this.a.get(viewType);
        eg5.e d = d(viewType);
        if (ag5Var2 == null || d == null) {
            return;
        }
        ag5Var2.c(viewType, this.b, d);
        this.f = ag5Var2;
        this.a.put(viewType, ag5Var2);
    }

    @Override // com.baidu.tieba.yf5
    public void c(ViewType viewType, @NonNull ag5 ag5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, ag5Var) == null) {
            this.a.put(viewType, ag5Var);
        }
    }

    public final eg5.e d(ViewType viewType) {
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
        return (eg5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yf5
    public void onChangeSkinType(int i) {
        ag5 ag5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (ag5Var = this.f) == null) {
            return;
        }
        ag5Var.e(i);
    }

    @Override // com.baidu.tieba.yf5
    public void onDestroy() {
        ag5 ag5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ag5Var = this.f) == null) {
            return;
        }
        ag5Var.b(this.b);
    }
}
