package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
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
public class v69 extends q69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v69 a;

        public a(v69 v69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v69Var;
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
                v69 v69Var = this.a;
                v69Var.e.d(v69Var.a.getString(R.string.obfuscated_res_0x7f0f053e));
                this.a.n0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v69(TbPageContext tbPageContext, NavigationBar navigationBar, LinearLayout linearLayout, EditorTools editorTools, c59 c59Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, c59Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, c59Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (c59) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.r69, com.baidu.tieba.f59
    public LinkedList F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i49 i49Var = this.E;
            if (i49Var == null) {
                return null;
            }
            return i49Var.W();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r69
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.r69, com.baidu.tieba.f59
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i49 i49Var = this.E;
            if (i49Var == null) {
                return 0;
            }
            return i49Var.V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.r69
    public void M(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            l49 f = g69.f(this.a);
            list.add(f);
            m49 g = g69.g(this.a);
            f.w(g);
            list.add(g);
            u49 o = g69.o(this.a);
            f.w(o);
            list.add(o);
            t49 n = g69.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            i49 c = g69.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            v49 p = g69.p(this.a);
            this.G = p;
            list.add(p);
            list.add(g69.h(this.a, this.C));
            h49 b = g69.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            p49 j = g69.j(this.a);
            this.I.w(j);
            list.add(j);
            w49 q = g69.q(this.a);
            this.H = q;
            list.add(q);
            list.add(g69.a(this.a));
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void O(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.C(true);
            editorTools.D(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                i69.h(this.a, editorTools, this);
                i69.j(this.a, editorTools, this);
                i69.k(this.a, editorTools, this);
                i69.b(this.a, editorTools, this);
                i69.i(this.a, editorTools);
                i69.f(this.a, editorTools, this);
                i69.e(this.a, editorTools, this);
                i69.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            i69.d(editorTools, this);
            i69.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                i69.g(this.a, editorTools, this);
                i69.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                i69.c(this.a, editorTools, this);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void P(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0c7c));
                p0(0, 0);
                q0(R.drawable.obfuscated_res_0x7f0809ae, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f14));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f16));
                if (this.p.getProZone() == 1) {
                    navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1637));
                }
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.share_to) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02de));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.r69, com.baidu.tieba.f59
    public void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.e(i, z);
            h49 h49Var = this.I;
            if (h49Var != null) {
                h49Var.j0();
            }
        }
    }

    @Override // com.baidu.tieba.r69, com.baidu.tieba.f59
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
