package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.ls7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ps7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public qs7 c;
    public ls7 d;
    public zr5 e;
    public ls7.a f;
    public Runnable g;

    /* loaded from: classes7.dex */
    public class a implements ls7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps7 a;

        public a(ps7 ps7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ps7Var;
        }

        @Override // com.baidu.tieba.ls7.a
        public void onStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        if (this.a.e == null) {
                            this.a.e = new zr5("anim_switch_trans_frs");
                        }
                        this.a.e.b();
                        BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(FrsActivityConfig.KEY_FPS_FRS_FROM, "frs", "tran");
                    }
                } else if (i == 2) {
                    this.a.k();
                    if (this.a.e != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        this.a.e.c();
                    }
                    BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(FrsActivityConfig.KEY_FPS_FRS);
                } else if (i == 0) {
                    this.a.j();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps7 a;

        public b(ps7 ps7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ps7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    public ps7(Context context, ViewGroup viewGroup, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.g = new b(this);
        this.a = context;
        this.b = viewGroup;
        qs7 qs7Var = new qs7(context);
        this.c = qs7Var;
        ls7 a2 = ms7.a(qs7Var, intent);
        this.d = a2;
        a2.b(this.f);
    }

    public static boolean i(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, intent)) == null) {
            if (intent == null || intent.getIntExtra("transition_type", 0) == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.g);
            if (this.d.a() == 1) {
                SafeHandler.getInst().postDelayed(this.g, 10L);
                return;
            }
            k();
            this.d.c();
        }
    }

    public final void g() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ViewGroup viewGroup = this.b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.b.getChildAt(0).setVisibility(8);
            }
            ViewGroup viewGroup2 = this.b;
            if (viewGroup2 != null && (findViewById = viewGroup2.findViewById(16908290)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = this.b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.b.getChildAt(0).setVisibility(0);
            }
            ViewGroup viewGroup2 = this.b;
            if (viewGroup2 != null && viewGroup2.findViewById(16908290) != null) {
                this.b.findViewById(16908290).setVisibility(0);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.b == null) {
            return;
        }
        f();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ViewParent parent = this.c.a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.c.a);
            }
            SafeHandler.getInst().removeCallbacks(this.g);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.b == null) {
            return;
        }
        j();
        this.b.addView(this.c.a);
        g();
        this.d.d();
    }
}
