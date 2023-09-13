package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.la3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pq3 implements la3.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ pq3 b;

        public a(pq3 pq3Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq3Var, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pq3Var;
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.a == null) {
                    this.b.a = new FrameLayout(this.a.getContext());
                    this.b.a.setBackgroundResource(R.color.obfuscated_res_0x7f060451);
                }
                this.a.removeView(this.b.a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.a.addView(this.b.a, layoutParams);
            }
        }
    }

    public pq3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public final void e(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) && viewGroup != null && (frameLayout = this.a) != null) {
            viewGroup.removeView(frameLayout);
            this.a = null;
        }
    }

    public final void f(la3 la3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, la3Var) == null) {
            Context context = la3Var.getContext();
            if (la3Var.getContext() instanceof ContextWrapper) {
                context = ((ContextWrapper) la3Var.getContext()).getBaseContext();
            }
            if (context instanceof Activity) {
                qn3.b((Activity) context, la3Var);
            }
        }
    }

    public final void d(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, view2) != null) || viewGroup == null || view2 == null || !(viewGroup instanceof FrameLayout)) {
            return;
        }
        view2.post(new a(this, viewGroup));
    }

    @Override // com.baidu.tieba.la3.c
    public void a(la3 la3Var, la3.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, la3Var, bVar) != null) || la3Var == null || bVar == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        f(la3Var);
        ViewGroup viewGroup = (ViewGroup) la3Var.findViewById(16908290);
        if (viewGroup != null) {
            if (ou2.M().a()) {
                d(viewGroup, bVar.r);
            } else {
                e(viewGroup);
            }
        }
    }
}
