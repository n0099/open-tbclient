package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.rn5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class mn5 implements ln5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, nn5> a;
    public final ViewGroup b;
    public final un5 c;
    public final rn5 d;
    public ViewType e;
    public nn5 f;

    public mn5(un5 un5Var, @NonNull ViewGroup viewGroup, @NonNull rn5 rn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {un5Var, viewGroup, rn5Var};
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
        this.c = un5Var;
        this.d = rn5Var;
    }

    @Override // com.baidu.tieba.ln5
    public void a(ViewType viewType, String str) {
        rn5.a aVar;
        rn5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.ln5
    public void c(ViewType viewType, @NonNull nn5 nn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, nn5Var) == null) {
            this.a.put(viewType, nn5Var);
        }
    }

    @Override // com.baidu.tieba.ln5
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
        un5 un5Var = this.c;
        if (un5Var != null && un5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        nn5 nn5Var = this.f;
        if (nn5Var != null) {
            nn5Var.b(this.b);
        }
        nn5 nn5Var2 = this.a.get(viewType);
        rn5.e d = d(viewType);
        if (nn5Var2 != null && d != null) {
            nn5Var2.c(viewType, this.b, d);
            this.f = nn5Var2;
            this.a.put(viewType, nn5Var2);
        }
    }

    public final rn5.e d(ViewType viewType) {
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
        return (rn5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ln5
    public void onChangeSkinType(int i) {
        nn5 nn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (nn5Var = this.f) != null) {
            nn5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.ln5
    public void onDestroy() {
        nn5 nn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (nn5Var = this.f) != null) {
            nn5Var.b(this.b);
        }
    }
}
