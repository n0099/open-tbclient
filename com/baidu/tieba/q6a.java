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
public class q6a extends l6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q6a a;

        public a(q6a q6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q6aVar;
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
                q6a q6aVar = this.a;
                q6aVar.e.c(q6aVar.a.getString(R.string.obfuscated_res_0x7f0f0565));
                this.a.n0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q6a(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull x4a x4aVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, x4aVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, x4aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (x4a) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.m6a, com.baidu.tieba.a5a
    public LinkedList<i65> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d4a d4aVar = this.E;
            if (d4aVar == null) {
                return null;
            }
            return d4aVar.a0();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m6a
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.m6a, com.baidu.tieba.a5a
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d4a d4aVar = this.E;
            if (d4aVar == null) {
                return 0;
            }
            return d4aVar.Z();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l6a, com.baidu.tieba.m6a
    public void M(@NonNull List<y4a<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            g4a f = b6a.f(this.a);
            list.add(f);
            h4a g = b6a.g(this.a);
            f.w(g);
            list.add(g);
            p4a o = b6a.o(this.a);
            f.w(o);
            list.add(o);
            o4a n = b6a.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            d4a c = b6a.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            q4a p = b6a.p(this.a);
            this.G = p;
            list.add(p);
            list.add(b6a.h(this.a, this.C));
            c4a b = b6a.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            k4a j = b6a.j(this.a);
            this.I.w(j);
            list.add(j);
            r4a q = b6a.q(this.a);
            this.H = q;
            list.add(q);
            list.add(b6a.a(this.a));
        }
    }

    @Override // com.baidu.tieba.l6a, com.baidu.tieba.m6a
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
                d6a.h(this.a, editorTools, this);
                d6a.j(this.a, editorTools, this);
                d6a.k(this.a, editorTools, this);
                d6a.b(this.a, editorTools, this);
                d6a.i(this.a, editorTools);
                d6a.f(this.a, editorTools, this);
                d6a.e(this.a, editorTools, this);
                d6a.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            d6a.d(editorTools, this);
            d6a.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                d6a.g(this.a, editorTools, this);
                d6a.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                d6a.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.l6a, com.baidu.tieba.m6a
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0d31));
                p0(0, 0);
                q0(R.drawable.obfuscated_res_0x7f080a0b, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0fc5));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0fc7));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1241) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02e7));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.m6a, com.baidu.tieba.a5a
    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.d(i, z);
            c4a c4aVar = this.I;
            if (c4aVar != null) {
                c4aVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.m6a, com.baidu.tieba.a5a
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        w0();
        if (m0()) {
            X();
            this.e.setResult(100);
            this.e.C();
            return;
        }
        h0(true);
    }
}
