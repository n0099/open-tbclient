package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class o6b extends m6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public v5b V;
    public u5b W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o6b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull y4b y4bVar, boolean z) {
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

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void L(@NonNull List<z4b<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new u5b(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        z0(list);
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            y0(editorTools);
            e6b.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.N(editorTools);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.T(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            v5b a = v5b.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.Q0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void O(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.O(navigationBar);
            v5b v5bVar = this.V;
            if (v5bVar != null) {
                if (TextUtils.isEmpty(v5bVar.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f113d);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void y0(@NonNull EditorTools editorTools) {
        v5b v5bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, editorTools) != null) || (v5bVar = this.V) == null) {
            return;
        }
        for (String str : v5bVar.e) {
            w5b.a(this.a, editorTools, this, str);
        }
    }

    public final void z0(@NonNull List<z4b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (z4b<?> z4bVar : list) {
                if (z4bVar instanceof p4b) {
                    this.D = (p4b) z4bVar;
                } else if (z4bVar instanceof e4b) {
                    this.E = (e4b) z4bVar;
                } else if (z4bVar instanceof o4b) {
                    this.F = (o4b) z4bVar;
                } else if (z4bVar instanceof r4b) {
                    this.G = (r4b) z4bVar;
                } else if (z4bVar instanceof s4b) {
                    this.H = (s4b) z4bVar;
                } else if (z4bVar instanceof d4b) {
                    this.I = (d4b) z4bVar;
                }
                if (z4bVar != null) {
                    z4bVar.q(list);
                }
            }
        }
    }
}
