package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes8.dex */
public class sxa extends nxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools V;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sxa a;

        public a(sxa sxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sxaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o0()) {
                    this.a.e.Q0(11, false);
                    this.a.p0(2);
                    return;
                }
                sxa sxaVar = this.a;
                sxaVar.e.b(sxaVar.a.getString(R.string.obfuscated_res_0x7f0f0610));
                this.a.p0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sxa(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull zva zvaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, zvaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, zvaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (zva) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.oxa, com.baidu.tieba.cwa
    public LinkedList<qa5> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fva fvaVar = this.E;
            if (fvaVar == null) {
                return null;
            }
            return fvaVar.X();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oxa
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            y0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.oxa, com.baidu.tieba.cwa
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            fva fvaVar = this.E;
            if (fvaVar == null) {
                return 0;
            }
            return fvaVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa, com.baidu.tieba.cwa
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            EditorTools editorTools = this.V;
            if (editorTools != null) {
                editorTools.s(15);
            }
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void M(@NonNull List<awa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            iva f = dxa.f(this.a);
            list.add(f);
            jva g = dxa.g(this.a);
            f.w(g);
            list.add(g);
            rva o = dxa.o(this.a);
            f.w(o);
            list.add(o);
            qva n = dxa.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            fva c = dxa.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            sva p = dxa.p(this.a);
            this.G = p;
            list.add(p);
            list.add(dxa.h(this.a, this.C));
            eva b = dxa.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            mva j = dxa.j(this.a);
            this.I.w(j);
            list.add(j);
            tva q = dxa.q(this.a);
            this.H = q;
            list.add(q);
            list.add(dxa.a(this.a));
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            this.V = editorTools;
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                fxa.h(this.a, editorTools, this);
                fxa.j(this.a, editorTools, this);
                fxa.k(this.a, editorTools, this);
                fxa.b(this.a, editorTools, this);
                fxa.i(this.a, editorTools);
                fxa.f(this.a, editorTools, this);
                fxa.e(this.a, editorTools, this);
                fxa.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            fxa.d(editorTools, this);
            fxa.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                fxa.g(this.a, editorTools, this);
                fxa.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                fxa.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
            if (yj5.isOn()) {
                D(new lh5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e3a));
                r0(0, 0);
                s0(R.drawable.obfuscated_res_0x7f080ba1, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1119));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f111b));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f13b6) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f0318));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.oxa, com.baidu.tieba.cwa
    public void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.e(i, z);
            eva evaVar = this.I;
            if (evaVar != null) {
                evaVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.oxa, com.baidu.tieba.cwa
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        y0();
        if (o0()) {
            X();
            this.e.setResult(100);
            this.e.x();
            return;
        }
        i0(true);
    }
}
