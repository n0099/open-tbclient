package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.ov5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class jv5 implements iv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, kv5> a;
    public final ViewGroup b;
    public final rv5 c;
    public final ov5 d;
    public ViewType e;
    public kv5 f;

    public jv5(rv5 rv5Var, @NonNull ViewGroup viewGroup, @NonNull ov5 ov5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rv5Var, viewGroup, ov5Var};
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
        this.c = rv5Var;
        this.d = ov5Var;
    }

    @Override // com.baidu.tieba.iv5
    public void a(ViewType viewType, String str) {
        ov5.a aVar;
        ov5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType == ViewType.EMPTY && (aVar = this.d.b) != null) {
                aVar.a = str;
            }
        }
    }

    @Override // com.baidu.tieba.iv5
    public void c(ViewType viewType, @NonNull kv5 kv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, kv5Var) == null) {
            this.a.put(viewType, kv5Var);
        }
    }

    @Override // com.baidu.tieba.iv5
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
        rv5 rv5Var = this.c;
        if (rv5Var != null && rv5Var.getView() != null) {
            View view2 = this.c.getView();
            if (viewType == ViewType.CONTENT) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        kv5 kv5Var = this.f;
        if (kv5Var != null) {
            kv5Var.b(this.b);
        }
        kv5 kv5Var2 = this.a.get(viewType);
        ov5.e d = d(viewType);
        if (kv5Var2 != null && d != null) {
            kv5Var2.c(viewType, this.b, d);
            this.f = kv5Var2;
            this.a.put(viewType, kv5Var2);
        }
    }

    public final ov5.e d(ViewType viewType) {
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
        return (ov5.e) invokeL.objValue;
    }

    @Override // com.baidu.tieba.iv5
    public void onChangeSkinType(int i) {
        kv5 kv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (kv5Var = this.f) != null) {
            kv5Var.e(i);
        }
    }

    @Override // com.baidu.tieba.iv5
    public void onDestroy() {
        kv5 kv5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (kv5Var = this.f) != null) {
            kv5Var.b(this.b);
        }
    }
}
