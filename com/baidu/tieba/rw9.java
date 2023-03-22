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
/* loaded from: classes6.dex */
public class rw9 extends mw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rw9 a;

        public a(rw9 rw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rw9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m0()) {
                    this.a.e.T0(11, false);
                    this.a.n0(2);
                    return;
                }
                rw9 rw9Var = this.a;
                rw9Var.e.f(rw9Var.a.getString(R.string.obfuscated_res_0x7f0f0567));
                this.a.n0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rw9(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull yu9 yu9Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, yu9Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, yu9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (yu9) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.nw9, com.baidu.tieba.bv9
    public LinkedList<e55> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            eu9 eu9Var = this.E;
            if (eu9Var == null) {
                return null;
            }
            return eu9Var.a0();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nw9
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.nw9, com.baidu.tieba.bv9
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            eu9 eu9Var = this.E;
            if (eu9Var == null) {
                return 0;
            }
            return eu9Var.Z();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void M(@NonNull List<zu9<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            hu9 f = cw9.f(this.a);
            list.add(f);
            iu9 g = cw9.g(this.a);
            f.w(g);
            list.add(g);
            qu9 o = cw9.o(this.a);
            f.w(o);
            list.add(o);
            pu9 n = cw9.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            eu9 c = cw9.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            ru9 p = cw9.p(this.a);
            this.G = p;
            list.add(p);
            list.add(cw9.h(this.a, this.C));
            du9 b = cw9.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            lu9 j = cw9.j(this.a);
            this.I.w(j);
            list.add(j);
            su9 q = cw9.q(this.a);
            this.H = q;
            list.add(q);
            list.add(cw9.a(this.a));
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.E(true);
            editorTools.F(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                ew9.h(this.a, editorTools, this);
                ew9.j(this.a, editorTools, this);
                ew9.k(this.a, editorTools, this);
                ew9.b(this.a, editorTools, this);
                ew9.i(this.a, editorTools);
                ew9.f(this.a, editorTools, this);
                ew9.e(this.a, editorTools, this);
                ew9.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            ew9.d(editorTools, this);
            ew9.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                ew9.g(this.a, editorTools, this);
                ew9.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                ew9.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0d35));
                p0(0, 0);
                q0(R.drawable.obfuscated_res_0x7f080a1b, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0fcc));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0fce));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f124b) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02e8));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.nw9, com.baidu.tieba.bv9
    public void c(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.c(i, z);
            du9 du9Var = this.I;
            if (du9Var != null) {
                du9Var.j0();
            }
        }
    }

    @Override // com.baidu.tieba.nw9, com.baidu.tieba.bv9
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        w0();
        if (m0()) {
            X();
            this.e.setResult(100);
            this.e.finish();
            return;
        }
        g0(true);
    }
}
