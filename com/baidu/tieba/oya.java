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
public class oya extends jya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oya a;

        public a(oya oyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oyaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o0()) {
                    this.a.e.S0(11, false);
                    this.a.p0(2);
                    return;
                }
                oya oyaVar = this.a;
                oyaVar.e.c(oyaVar.a.getString(R.string.obfuscated_res_0x7f0f0610));
                this.a.p0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oya(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull vwa vwaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, vwaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, vwaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (vwa) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public LinkedList<bc5> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bwa bwaVar = this.E;
            if (bwaVar == null) {
                return null;
            }
            return bwaVar.X();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kya
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            y0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            bwa bwaVar = this.E;
            if (bwaVar == null) {
                return 0;
            }
            return bwaVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void M(@NonNull List<wwa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ewa f = zxa.f(this.a);
            list.add(f);
            fwa g = zxa.g(this.a);
            f.w(g);
            list.add(g);
            nwa o = zxa.o(this.a);
            f.w(o);
            list.add(o);
            mwa n = zxa.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            bwa c = zxa.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            owa p = zxa.p(this.a);
            this.G = p;
            list.add(p);
            list.add(zxa.h(this.a, this.C));
            awa b = zxa.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            iwa j = zxa.j(this.a);
            this.I.w(j);
            list.add(j);
            pwa q = zxa.q(this.a);
            this.H = q;
            list.add(q);
            list.add(zxa.a(this.a));
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                bya.h(this.a, editorTools, this);
                bya.j(this.a, editorTools, this);
                bya.k(this.a, editorTools, this);
                bya.b(this.a, editorTools, this);
                bya.i(this.a, editorTools);
                bya.f(this.a, editorTools, this);
                bya.e(this.a, editorTools, this);
                bya.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            bya.d(editorTools, this);
            bya.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                bya.g(this.a, editorTools, this);
                bya.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                bya.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
            if (ml5.isOn()) {
                D(new zi5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e38));
                r0(0, 0);
                s0(R.drawable.obfuscated_res_0x7f080b9d, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1116));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1118));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f13b2) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f0318));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.e(i, z);
            awa awaVar = this.I;
            if (awaVar != null) {
                awaVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        y0();
        if (o0()) {
            X();
            this.e.setResult(100);
            this.e.y();
            return;
        }
        i0(true);
    }
}
