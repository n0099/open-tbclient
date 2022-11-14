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
public class p89 extends k89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p89 a;

        public a(p89 p89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m0()) {
                    this.a.e.v0(11, false);
                    this.a.n0(2);
                    return;
                }
                p89 p89Var = this.a;
                p89Var.e.d(p89Var.a.getString(R.string.obfuscated_res_0x7f0f0542));
                this.a.n0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p89(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull w69 w69Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, w69Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, w69Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (w69) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.l89, com.baidu.tieba.z69
    public LinkedList<i05> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c69 c69Var = this.E;
            if (c69Var == null) {
                return null;
            }
            return c69Var.W();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l89
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.l89, com.baidu.tieba.z69
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c69 c69Var = this.E;
            if (c69Var == null) {
                return 0;
            }
            return c69Var.V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public void M(@NonNull List<x69<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            f69 f = a89.f(this.a);
            list.add(f);
            g69 g = a89.g(this.a);
            f.w(g);
            list.add(g);
            o69 o = a89.o(this.a);
            f.w(o);
            list.add(o);
            n69 n = a89.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            c69 c = a89.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            p69 p = a89.p(this.a);
            this.G = p;
            list.add(p);
            list.add(a89.h(this.a, this.C));
            b69 b = a89.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            j69 j = a89.j(this.a);
            this.I.w(j);
            list.add(j);
            q69 q = a89.q(this.a);
            this.H = q;
            list.add(q);
            list.add(a89.a(this.a));
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
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
                c89.h(this.a, editorTools, this);
                c89.j(this.a, editorTools, this);
                c89.k(this.a, editorTools, this);
                c89.b(this.a, editorTools, this);
                c89.i(this.a, editorTools);
                c89.f(this.a, editorTools, this);
                c89.e(this.a, editorTools, this);
                c89.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            c89.d(editorTools, this);
            c89.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                c89.g(this.a, editorTools, this);
                c89.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                c89.c(this.a, editorTools, this);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0c95));
                p0(0, 0);
                q0(R.drawable.obfuscated_res_0x7f0809cb, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f31));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f33));
                if (this.p.getProZone() == 1) {
                    navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f165d));
                }
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.share_to) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02df));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.l89, com.baidu.tieba.z69
    public void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.e(i, z);
            b69 b69Var = this.I;
            if (b69Var != null) {
                b69Var.j0();
            }
        }
    }

    @Override // com.baidu.tieba.l89, com.baidu.tieba.z69
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
