package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uf4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements uf4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.uf4.a
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            view2.setAlpha(1.0f);
        }

        @Override // com.baidu.tieba.uf4.a
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || view2 == null) {
                return;
            }
            view2.setAlpha(0.2f);
        }
    }

    public static void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, view2) == null) {
            b(view2, null);
        }
    }

    public static void b(View view2, Drawable drawable) {
        uf4 uf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, view2, drawable) != null) || view2 == null) {
            return;
        }
        if (drawable == null) {
            uf4Var = new uf4();
        } else {
            uf4Var = new uf4(drawable);
        }
        uf4Var.b(view2);
        uf4Var.a(new a());
        view2.setBackground(uf4Var);
    }
}
