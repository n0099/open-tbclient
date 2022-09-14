package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class o59 extends k59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o59 a;

        public a(o59 o59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o59Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l0()) {
                    this.a.e.w0(11, false);
                    this.a.m0(2);
                    return;
                }
                o59 o59Var = this.a;
                o59Var.e.d(o59Var.a.getString(R.string.obfuscated_res_0x7f0f0536));
                this.a.m0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o59(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull c49 c49Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, c49Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, c49Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (c49) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public LinkedList<vy4> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            k39 k39Var = this.E;
            if (k39Var == null) {
                return null;
            }
            return k39Var.U();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l59
    public void M(@NonNull List<d49<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            m39 e = a59.e(this.a);
            list.add(e);
            n39 f = a59.f(this.a);
            e.u(f);
            list.add(f);
            v39 n = a59.n(this.a);
            e.u(n);
            list.add(n);
            u39 m = a59.m(this.a, this, this.s, this.J);
            this.D = m;
            list.add(m);
            k39 c = a59.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            e.u(c);
            list.add(this.E);
            w39 o = a59.o(this.a);
            this.G = o;
            list.add(o);
            list.add(a59.g(this.a, this.C));
            j39 b = a59.b(this.a);
            this.I = b;
            b.u(this.E);
            f.u(this.I);
            list.add(this.I);
            q39 i = a59.i(this.a);
            this.I.u(i);
            list.add(i);
            x39 p = a59.p(this.a);
            this.H = p;
            list.add(p);
            list.add(a59.a(this.a));
        }
    }

    @Override // com.baidu.tieba.k59, com.baidu.tieba.l59
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.C(true);
            editorTools.D(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                c59.h(this.a, editorTools, this);
                c59.j(this.a, editorTools, this);
                c59.k(this.a, editorTools, this);
                c59.b(this.a, editorTools, this);
                c59.i(this.a, editorTools);
                c59.f(this.a, editorTools, this);
                c59.e(this.a, editorTools, this);
                c59.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            c59.d(editorTools, this);
            c59.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                c59.g(this.a, editorTools, this);
                c59.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                c59.c(this.a, editorTools, this);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.k59, com.baidu.tieba.l59
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0c6b));
                o0(0, 0);
                p0(R.drawable.obfuscated_res_0x7f0809ab, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f02));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f04));
                if (this.p.getProZone() == 1) {
                    navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f161c));
                }
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.share_to) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02de));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.l59
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            u0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void b(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.b(i, z);
            j39 j39Var = this.I;
            if (j39Var != null) {
                j39Var.h0();
            }
        }
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            k39 k39Var = this.E;
            if (k39Var == null) {
                return 0;
            }
            return k39Var.T();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l59, com.baidu.tieba.f49
    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a.getPageActivity() == null) {
            return;
        }
        u0();
        if (l0()) {
            X();
            this.e.setResult(100);
            this.e.finish();
            return;
        }
        g0(true);
    }
}
