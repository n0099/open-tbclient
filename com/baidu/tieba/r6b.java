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
/* loaded from: classes7.dex */
public class r6b extends m6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r6b a;

        public a(r6b r6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r6bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n0()) {
                    this.a.e.Q0(11, false);
                    this.a.o0(2);
                    return;
                }
                r6b r6bVar = this.a;
                r6bVar.e.a(r6bVar.a.getString(R.string.obfuscated_res_0x7f0f061a));
                this.a.o0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r6b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull y4b y4bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, y4bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, y4bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (y4b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public LinkedList<hb5> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e4b e4bVar = this.E;
            if (e4bVar == null) {
                return null;
            }
            return e4bVar.X();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n6b
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x0();
            super.a0();
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            e4b e4bVar = this.E;
            if (e4bVar == null) {
                return 0;
            }
            return e4bVar.W();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void L(@NonNull List<z4b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            h4b f = c6b.f(this.a);
            list.add(f);
            i4b g = c6b.g(this.a);
            f.w(g);
            list.add(g);
            q4b o = c6b.o(this.a);
            f.w(o);
            list.add(o);
            p4b n = c6b.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            e4b c = c6b.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            f.w(c);
            list.add(this.E);
            r4b p = c6b.p(this.a);
            this.G = p;
            list.add(p);
            list.add(c6b.h(this.a, this.C));
            d4b b = c6b.b(this.a);
            this.I = b;
            b.w(this.E);
            g.w(this.I);
            list.add(this.I);
            l4b j = c6b.j(this.a);
            this.I.w(j);
            list.add(j);
            s4b q = c6b.q(this.a);
            this.H = q;
            list.add(q);
            list.add(c6b.a(this.a));
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                e6b.h(this.a, editorTools, this);
                e6b.j(this.a, editorTools, this);
                e6b.k(this.a, editorTools, this);
                e6b.b(this.a, editorTools, this);
                e6b.i(this.a, editorTools);
                e6b.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            e6b.d(editorTools, this);
            e6b.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                e6b.g(this.a, editorTools, this);
                e6b.l(this.a, editorTools, this);
            }
            if (!"main_tab".equals(this.p.getFrom())) {
                e6b.c(this.a, editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            super.N(editorTools);
            if (fl5.isOn()) {
                C(new si5(76, 15, this.p.getForumId()));
            }
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.O(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0e59));
                q0(0, 0);
                r0(R.drawable.obfuscated_res_0x7f080bbe, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
            } else if ("1".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f113b));
            } else if ("2".equals(this.p.getCallFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f113d));
            } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f13dc) + this.p.getForumName() + this.a.getString(R.string.obfuscated_res_0x7f0f031a));
            } else {
                navigationBar.setCenterTextTitle("");
            }
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void f(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.f(i, z);
            d4b d4bVar = this.I;
            if (d4bVar != null) {
                d4bVar.j0();
            }
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.a.getPageActivity() == null) {
            return;
        }
        x0();
        if (n0()) {
            X();
            this.e.setResult(100);
            this.e.x();
            return;
        }
        h0(true);
    }
}
