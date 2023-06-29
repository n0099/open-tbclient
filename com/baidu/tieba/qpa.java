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
public class qpa extends lpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qpa a;

        public a(qpa qpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qpaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qpaVar;
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
                qpa qpaVar = this.a;
                qpaVar.e.c(qpaVar.a.getString(R.string.obfuscated_res_0x7f0f060d));
                this.a.p0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qpa(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull xna xnaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, xnaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, xnaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (xna) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.mpa, com.baidu.tieba.aoa
    public LinkedList<jb5> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            dna dnaVar = this.E;
            if (dnaVar == null) {
                return null;
            }
            return dnaVar.X();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mpa
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            y0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.mpa, com.baidu.tieba.aoa
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            dna dnaVar = this.E;
            if (dnaVar == null) {
                return 0;
            }
            return dnaVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lpa, com.baidu.tieba.mpa
    public void M(@NonNull List<yna<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            gna f = bpa.f(this.a);
            list.add(f);
            hna g = bpa.g(this.a);
            f.w(g);
            list.add(g);
            pna o = bpa.o(this.a);
            f.w(o);
            list.add(o);
            ona n = bpa.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            dna c = bpa.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            qna p = bpa.p(this.a);
            this.G = p;
            list.add(p);
            list.add(bpa.h(this.a, this.C));
            cna b = bpa.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            kna j = bpa.j(this.a);
            this.I.w(j);
            list.add(j);
            rna q = bpa.q(this.a);
            this.H = q;
            list.add(q);
            list.add(bpa.a(this.a));
        }
    }

    @Override // com.baidu.tieba.lpa, com.baidu.tieba.mpa
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
                dpa.h(this.a, editorTools, this);
                dpa.j(this.a, editorTools, this);
                dpa.k(this.a, editorTools, this);
                dpa.b(this.a, editorTools, this);
                dpa.i(this.a, editorTools);
                dpa.f(this.a, editorTools, this);
                dpa.e(this.a, editorTools, this);
                dpa.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            dpa.d(editorTools, this);
            dpa.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                dpa.g(this.a, editorTools, this);
                dpa.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                dpa.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
            if (pk5.isOn()) {
                D(new ci5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.lpa, com.baidu.tieba.mpa
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e28));
                r0(0, 0);
                s0(R.drawable.obfuscated_res_0x7f080b92, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1104));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1106));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f139c) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f0318));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.mpa, com.baidu.tieba.aoa
    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.d(i, z);
            cna cnaVar = this.I;
            if (cnaVar != null) {
                cnaVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.mpa, com.baidu.tieba.aoa
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
