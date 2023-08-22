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
/* loaded from: classes6.dex */
public class j4b extends c4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j4b a;

        public a(j4b j4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j4bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n0()) {
                    this.a.e.Q0(9, false);
                    this.a.o0(1);
                    return;
                }
                j4b j4bVar = this.a;
                j4bVar.e.b(j4bVar.a.getString(R.string.obfuscated_res_0x7f0f0617));
                this.a.o0(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j4b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull o2b o2bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, o2bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, o2bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (o2b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void L(@NonNull List<p2b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            x1b f = s3b.f(this.a);
            list.add(f);
            y1b g = s3b.g(this.a);
            f.w(g);
            list.add(g);
            list.add(s3b.o(this.a));
            f2b n = s3b.n(this.a, this, this.s, this.J);
            this.D = n;
            list.add(n);
            e2b m = s3b.m(this.a, this, this.d, this.C, this.s, this.J);
            this.F = m;
            f.w(m);
            list.add(this.F);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(3);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setMoreVipIcon(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            u3b.h(this.a, editorTools, this);
            u3b.d(editorTools, this);
            u3b.a(this.a, editorTools, this);
            u3b.b(this.a, editorTools, this);
            u3b.i(this.a, editorTools);
            u3b.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.N(editorTools);
        }
    }

    @Override // com.baidu.tieba.c4b, com.baidu.tieba.d4b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.O(navigationBar);
            if (this.q) {
                navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1263));
                q0(0, 0);
                r0(R.drawable.obfuscated_res_0x7f080baf, R.dimen.tbds31, R.dimen.tbds31, R.dimen.tbds0);
                this.j.setOnClickListener(new a(this));
                return;
            }
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1110));
        }
    }
}
