package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.local.view.LocalInputContainer;
import com.baidu.tieba.c75;
import com.baidu.tieba.nm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public Context b;
    public View c;
    public m65 d;
    public o65 e;

    public l65(Context context, View view2, m65 m65Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, m65Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (k(context, view2, m65Var)) {
            this.b = context;
            this.c = view2;
            this.d = m65Var;
            c();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.c instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.c).addView(this.a, layoutParams);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            this.a.o();
            if (this.c == null || this.a.getParent() == null) {
                return;
            }
            View view2 = this.c;
            if (view2 instanceof RelativeLayout) {
                ((RelativeLayout) view2).removeView(this.a);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            e();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EditorTools a = ((t65) new u65(this.d).a(this.b)).a();
            this.a = a;
            a.setId(R.id.obfuscated_res_0x7f09142c);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.h65
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        l65.this.f(view2);
                    }
                }
            });
            Context context = this.b;
            if (context instanceof Activity) {
                c75.b((Activity) context, this.a.b, new c75.b() { // from class: com.baidu.tieba.i65
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.c75.b
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            l65.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.n(36).m).setSendBtnClickListener(new LocalInputContainer.c() { // from class: com.baidu.tieba.j65
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(m65 m65Var, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, m65Var, str) == null) {
                        l65.this.h(m65Var, str);
                    }
                }
            });
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = new o65(this.d);
        }
    }

    public /* synthetic */ void f(View view2) {
        b();
    }

    public /* synthetic */ void g(boolean z) {
        if (z) {
            this.a.b.setVisibility(0);
            this.a.b.setBackgroundColorId(R.color.CAM_X0207);
            return;
        }
        this.a.b.o();
    }

    public /* synthetic */ void h(m65 m65Var, String str) {
        o65 o65Var = this.e;
        if (o65Var != null) {
            o65Var.f(m65Var, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", m65Var.a().a);
            TiebaStatic.log(statisticItem);
        }
    }

    public /* synthetic */ void i(String str) {
        this.a.A(new h55(6, 36, str));
    }

    public final void j() {
        o65 o65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (o65Var = this.e) == null) {
            return;
        }
        o65Var.d(new nm8.h() { // from class: com.baidu.tieba.k65
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.nm8.h
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    l65.this.i(str);
                }
            }
        });
    }

    public final boolean k(Context context, View view2, m65 m65Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view2, m65Var)) == null) ? (!(context instanceof Activity) || view2 == null || m65Var == null) ? false : true : invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.a) == null || editorTools.n(36) == null) {
            return;
        }
        t55 t55Var = this.a.n(36).m;
        if (t55Var instanceof LocalInputContainer) {
            String inputContentDraft = ((LocalInputContainer) t55Var).getInputContentDraft();
            o65 o65Var = this.e;
            if (o65Var != null) {
                o65Var.e(inputContentDraft);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.a == null) {
            return;
        }
        j();
        this.a.j();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SHOW);
        statisticItem.addParam("obj_id", this.d.a().a);
        TiebaStatic.log(statisticItem);
    }
}
