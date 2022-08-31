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
import com.baidu.tieba.h45;
import com.baidu.tieba.kk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public Context b;
    public View c;
    public q35 d;
    public s35 e;

    public p35(Context context, View view2, q35 q35Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, q35Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (k(context, view2, q35Var)) {
            this.b = context;
            this.c = view2;
            this.d = q35Var;
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
            EditorTools a = ((x35) new y35(this.d).a(this.b)).a();
            this.a = a;
            a.setId(R.id.obfuscated_res_0x7f091408);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.n35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        p35.this.f(view2);
                    }
                }
            });
            Context context = this.b;
            if (context instanceof Activity) {
                h45.b((Activity) context, this.a.b, new h45.b() { // from class: com.baidu.tieba.m35
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.h45.b
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            p35.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.n(36).m).setSendBtnClickListener(new LocalInputContainer.c() { // from class: com.baidu.tieba.o35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(q35 q35Var, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, q35Var, str) == null) {
                        p35.this.h(q35Var, str);
                    }
                }
            });
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = new s35(this.d);
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

    public /* synthetic */ void h(q35 q35Var, String str) {
        s35 s35Var = this.e;
        if (s35Var != null) {
            s35Var.f(q35Var, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", q35Var.a().a);
            TiebaStatic.log(statisticItem);
        }
    }

    public /* synthetic */ void i(String str) {
        this.a.A(new l25(6, 36, str));
    }

    public final void j() {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (s35Var = this.e) == null) {
            return;
        }
        s35Var.d(new kk8.h() { // from class: com.baidu.tieba.l35
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.kk8.h
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    p35.this.i(str);
                }
            }
        });
    }

    public final boolean k(Context context, View view2, q35 q35Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view2, q35Var)) == null) ? (!(context instanceof Activity) || view2 == null || q35Var == null) ? false : true : invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.a) == null || editorTools.n(36) == null) {
            return;
        }
        x25 x25Var = this.a.n(36).m;
        if (x25Var instanceof LocalInputContainer) {
            String inputContentDraft = ((LocalInputContainer) x25Var).getInputContentDraft();
            s35 s35Var = this.e;
            if (s35Var != null) {
                s35Var.e(inputContentDraft);
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
