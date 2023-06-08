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
public class jja extends eja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jja a;

        public a(jja jjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jjaVar;
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
                jja jjaVar = this.a;
                jjaVar.e.c(jjaVar.a.getString(R.string.obfuscated_res_0x7f0f0609));
                this.a.p0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jja(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull qha qhaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, qhaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, qhaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (qha) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.fja, com.baidu.tieba.tha
    public LinkedList<fb5> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wga wgaVar = this.E;
            if (wgaVar == null) {
                return null;
            }
            return wgaVar.X();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fja
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            y0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.fja, com.baidu.tieba.tha
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            wga wgaVar = this.E;
            if (wgaVar == null) {
                return 0;
            }
            return wgaVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public void M(@NonNull List<rha<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            zga f = uia.f(this.a);
            list.add(f);
            aha g = uia.g(this.a);
            f.w(g);
            list.add(g);
            iha o = uia.o(this.a);
            f.w(o);
            list.add(o);
            hha n = uia.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            wga c = uia.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            jha p = uia.p(this.a);
            this.G = p;
            list.add(p);
            list.add(uia.h(this.a, this.C));
            vga b = uia.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            dha j = uia.j(this.a);
            this.I.w(j);
            list.add(j);
            kha q = uia.q(this.a);
            this.H = q;
            list.add(q);
            list.add(uia.a(this.a));
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
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
                wia.h(this.a, editorTools, this);
                wia.j(this.a, editorTools, this);
                wia.k(this.a, editorTools, this);
                wia.b(this.a, editorTools, this);
                wia.i(this.a, editorTools);
                wia.f(this.a, editorTools, this);
                wia.e(this.a, editorTools, this);
                wia.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            wia.d(editorTools, this);
            wia.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                wia.g(this.a, editorTools, this);
                wia.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                wia.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
            if (hk5.isOn()) {
                D(new uh5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.eja, com.baidu.tieba.fja
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e08));
                r0(0, 0);
                s0(R.drawable.obfuscated_res_0x7f080b83, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f10e3));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f10e5));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f137b) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f0315));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.fja, com.baidu.tieba.tha
    public void d(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.d(i, z);
            vga vgaVar = this.I;
            if (vgaVar != null) {
                vgaVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.fja, com.baidu.tieba.tha
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
