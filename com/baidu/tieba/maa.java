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
public class maa extends haa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ maa a;

        public a(maa maaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = maaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m0()) {
                    this.a.e.U0(11, false);
                    this.a.n0(2);
                    return;
                }
                maa maaVar = this.a;
                maaVar.e.c(maaVar.a.getString(R.string.obfuscated_res_0x7f0f0572));
                this.a.n0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public maa(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull t8a t8aVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, t8aVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, t8aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (t8a) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.iaa, com.baidu.tieba.w8a
    public LinkedList<y65> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            z7a z7aVar = this.E;
            if (z7aVar == null) {
                return null;
            }
            return z7aVar.a0();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iaa
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.iaa, com.baidu.tieba.w8a
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            z7a z7aVar = this.E;
            if (z7aVar == null) {
                return 0;
            }
            return z7aVar.Z();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.haa, com.baidu.tieba.iaa
    public void M(@NonNull List<u8a<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            c8a f = x9a.f(this.a);
            list.add(f);
            d8a g = x9a.g(this.a);
            f.w(g);
            list.add(g);
            l8a o = x9a.o(this.a);
            f.w(o);
            list.add(o);
            k8a n = x9a.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            z7a c = x9a.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            m8a p = x9a.p(this.a);
            this.G = p;
            list.add(p);
            list.add(x9a.h(this.a, this.C));
            y7a b = x9a.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            g8a j = x9a.j(this.a);
            this.I.w(j);
            list.add(j);
            n8a q = x9a.q(this.a);
            this.H = q;
            list.add(q);
            list.add(x9a.a(this.a));
        }
    }

    @Override // com.baidu.tieba.haa, com.baidu.tieba.iaa
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
                z9a.h(this.a, editorTools, this);
                z9a.j(this.a, editorTools, this);
                z9a.k(this.a, editorTools, this);
                z9a.b(this.a, editorTools, this);
                z9a.i(this.a, editorTools);
                z9a.f(this.a, editorTools, this);
                z9a.e(this.a, editorTools, this);
                z9a.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            z9a.d(editorTools, this);
            z9a.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                z9a.g(this.a, editorTools, this);
                z9a.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                z9a.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.haa, com.baidu.tieba.iaa
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0d48));
                p0(0, 0);
                q0(R.drawable.obfuscated_res_0x7f080a38, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0fdd));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0fdf));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f125a) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f02e5));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.iaa, com.baidu.tieba.w8a
    public void e(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.e(i, z);
            y7a y7aVar = this.I;
            if (y7aVar != null) {
                y7aVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.iaa, com.baidu.tieba.w8a
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
