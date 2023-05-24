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
/* loaded from: classes7.dex */
public class pca extends kca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pca a;

        public a(pca pcaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pcaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pcaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o0()) {
                    this.a.e.U0(11, false);
                    this.a.p0(2);
                    return;
                }
                pca pcaVar = this.a;
                pcaVar.e.c(pcaVar.a.getString(R.string.obfuscated_res_0x7f0f05d6));
                this.a.p0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pca(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull waa waaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, waaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, waaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (waa) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.lca, com.baidu.tieba.zaa
    public LinkedList<h85> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            caa caaVar = this.E;
            if (caaVar == null) {
                return null;
            }
            return caaVar.W();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lca
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            y0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.lca, com.baidu.tieba.zaa
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            caa caaVar = this.E;
            if (caaVar == null) {
                return 0;
            }
            return caaVar.V();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.kca, com.baidu.tieba.lca
    public void M(@NonNull List<xaa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            faa f = aca.f(this.a);
            list.add(f);
            gaa g = aca.g(this.a);
            f.w(g);
            list.add(g);
            oaa o = aca.o(this.a);
            f.w(o);
            list.add(o);
            naa n = aca.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            caa c = aca.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            paa p = aca.p(this.a);
            this.G = p;
            list.add(p);
            list.add(aca.h(this.a, this.C));
            baa b = aca.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            jaa j = aca.j(this.a);
            this.I.w(j);
            list.add(j);
            qaa q = aca.q(this.a);
            this.H = q;
            list.add(q);
            list.add(aca.a(this.a));
        }
    }

    @Override // com.baidu.tieba.kca, com.baidu.tieba.lca
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
                cca.h(this.a, editorTools, this);
                cca.j(this.a, editorTools, this);
                cca.k(this.a, editorTools, this);
                cca.b(this.a, editorTools, this);
                cca.i(this.a, editorTools);
                cca.f(this.a, editorTools, this);
                cca.e(this.a, editorTools, this);
                cca.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            cca.d(editorTools, this);
            cca.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                cca.g(this.a, editorTools, this);
                cca.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                cca.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.kca, com.baidu.tieba.lca
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0dcf));
                r0(0, 0);
                s0(R.drawable.obfuscated_res_0x7f080b5f, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1099));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f109b));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1329) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f030f));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.lca, com.baidu.tieba.zaa
    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.d(i, z);
            baa baaVar = this.I;
            if (baaVar != null) {
                baaVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.lca, com.baidu.tieba.zaa
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        y0();
        if (o0()) {
            X();
            this.e.setResult(100);
            this.e.C();
            return;
        }
        i0(true);
    }
}
