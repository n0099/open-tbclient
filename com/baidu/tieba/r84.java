package com.baidu.tieba;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.gb3;
import com.baidu.tieba.s84;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FullScreenFloatView a;

    /* loaded from: classes7.dex */
    public class a implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ r84 b;

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onDrag() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(r84 r84Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r84Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r84Var;
            this.a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.d(this.a);
            }
        }
    }

    public r84() {
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

    public void c(s84.c cVar, Activity activity) {
        q84 q84Var;
        wb4 wb4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, activity) == null) && activity != null && this.a == null) {
            if (cVar != null && (wb4Var = cVar.c) != null) {
                q84Var = wb4Var.f;
            } else {
                q84Var = null;
            }
            if (q84.f(q84Var).b()) {
                b(activity);
            }
        }
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            FullScreenFloatView a2 = la3.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.a = a2;
            a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f01a1));
            this.a.setFloatImageBackground(R.drawable.obfuscated_res_0x7f080177);
            this.a.setAutoAttachEnable(false);
            this.a.setDragImageListener(new a(this, activity));
            this.a.setVisibility(0);
        }
    }

    public final void d(Activity activity) {
        cc3 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && (M = cc3.M()) != null && M.Y() != null) {
            Resources resources = activity.getResources();
            String u = SwanInspectorEndpoint.v().u(resources);
            gb3.a aVar = new gb3.a(activity);
            aVar.V(resources.getString(R.string.obfuscated_res_0x7f0f0207));
            aVar.x(u);
            aVar.n(new kr3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f01ce, null);
            aVar.X();
        }
    }
}
