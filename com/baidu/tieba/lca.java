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
/* loaded from: classes6.dex */
public class lca extends jca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public sba V;
    public rba W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lca(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull vaa vaaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, vaaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, vaaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (vaa) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A0(@NonNull List<waa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (waa<?> waaVar : list) {
                if (waaVar instanceof maa) {
                    this.D = (maa) waaVar;
                } else if (waaVar instanceof baa) {
                    this.E = (baa) waaVar;
                } else if (waaVar instanceof laa) {
                    this.F = (laa) waaVar;
                } else if (waaVar instanceof oaa) {
                    this.G = (oaa) waaVar;
                } else if (waaVar instanceof paa) {
                    this.H = (paa) waaVar;
                } else if (waaVar instanceof aaa) {
                    this.I = (aaa) waaVar;
                }
                if (waaVar != null) {
                    waaVar.q(list);
                }
            }
        }
    }

    @Override // com.baidu.tieba.jca, com.baidu.tieba.kca
    public void M(@NonNull List<waa<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new rba(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        A0(list);
    }

    @Override // com.baidu.tieba.jca, com.baidu.tieba.kca
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.E(true);
            editorTools.F(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            z0(editorTools);
            bca.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.jca, com.baidu.tieba.kca
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            sba a = sba.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.U0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.jca, com.baidu.tieba.kca
    public void P(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, navigationBar) == null) {
            super.P(navigationBar);
            sba sbaVar = this.V;
            if (sbaVar != null) {
                if (TextUtils.isEmpty(sbaVar.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f109b);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void z0(@NonNull EditorTools editorTools) {
        sba sbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, editorTools) != null) || (sbaVar = this.V) == null) {
            return;
        }
        for (String str : sbaVar.e) {
            tba.a(this.a, editorTools, this, str);
        }
    }
}
