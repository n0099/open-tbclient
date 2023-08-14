package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class uxa extends nxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uxa a;

        public a(uxa uxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uxaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o0()) {
                    this.a.e.Q0(9, false);
                    this.a.p0(1);
                    return;
                }
                uxa uxaVar = this.a;
                uxaVar.e.b(uxaVar.a.getString(R.string.obfuscated_res_0x7f0f0610));
                this.a.p0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uxa(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull zva zvaVar, boolean z) {
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

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void M(@NonNull List<awa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            iva f = dxa.f(this.a);
            list.add(f);
            jva g = dxa.g(this.a);
            f.w(g);
            list.add(g);
            list.add(dxa.o(this.a));
            qva n = dxa.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            pva m = dxa.m(this.a, this, this.d, this.C, this.s, this.J);
            this.F = m;
            f.w(m);
            list.add(this.F);
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(3);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setMoreVipIcon(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            fxa.h(this.a, editorTools, this);
            fxa.d(editorTools, this);
            fxa.a(this.a, editorTools, this);
            fxa.b(this.a, editorTools, this);
            fxa.i(this.a, editorTools);
            fxa.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1257));
                r0(0, 0);
                s0(R.drawable.obfuscated_res_0x7f080ba1, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
                return;
            }
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1105));
        }
    }
}
