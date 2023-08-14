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
import com.baidu.tieba.hj5;
import com.baidu.tieba.vaa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public Context b;
    public View c;
    public ri5 d;
    public ti5 e;

    public qi5(Context context, View view2, ri5 ri5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, ri5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (!k(context, view2, ri5Var)) {
            return;
        }
        this.b = context;
        this.c = view2;
        this.d = ri5Var;
        c();
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
            this.a.q();
            if (this.c != null && this.a.getParent() != null) {
                View view2 = this.c;
                if (view2 instanceof RelativeLayout) {
                    ((RelativeLayout) view2).removeView(this.a);
                }
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = new ti5(this.d);
        }
    }

    public final void j() {
        ti5 ti5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (ti5Var = this.e) == null) {
            return;
        }
        ti5Var.d(new vaa.h() { // from class: com.baidu.tieba.mi5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.vaa.h
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    qi5.this.i(str);
                }
            }
        });
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EditorTools b = ((yi5) new zi5(this.d).a(this.b)).b();
            this.a = b;
            b.setId(R.id.local_input_tool);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pi5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        qi5.this.f(view2);
                    }
                }
            });
            Context context = this.b;
            if (context instanceof Activity) {
                hj5.b((Activity) context, this.a.b, new hj5.b() { // from class: com.baidu.tieba.oi5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.hj5.b
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            qi5.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.p(36).m).setSendBtnClickListener(new LocalInputContainer.c() { // from class: com.baidu.tieba.ni5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(ri5 ri5Var, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, ri5Var, str) == null) {
                        qi5.this.h(ri5Var, str);
                    }
                }
            });
            a();
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

    public /* synthetic */ void i(String str) {
        this.a.D(new lh5(6, 36, str));
    }

    public /* synthetic */ void h(ri5 ri5Var, String str) {
        ti5 ti5Var = this.e;
        if (ti5Var != null) {
            ti5Var.f(ri5Var, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", ri5Var.a().a);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean k(Context context, View view2, ri5 ri5Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view2, ri5Var)) == null) {
            if ((context instanceof Activity) && view2 != null && ri5Var != null) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (editorTools = this.a) != null && editorTools.p(36) != null) {
            yh5 yh5Var = this.a.p(36).m;
            if (yh5Var instanceof LocalInputContainer) {
                String inputContentDraft = ((LocalInputContainer) yh5Var).getInputContentDraft();
                ti5 ti5Var = this.e;
                if (ti5Var != null) {
                    ti5Var.e(inputContentDraft);
                }
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.a != null) {
            j();
            this.a.j();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SHOW);
            statisticItem.addParam("obj_id", this.d.a().a);
            TiebaStatic.log(statisticItem);
        }
    }
}
