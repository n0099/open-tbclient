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
/* loaded from: classes5.dex */
public class ow9 extends mw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public vv9 V;
    public uv9 W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow9(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull yu9 yu9Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, yu9Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, yu9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (yu9) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void M(@NonNull List<zu9<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new uv9(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        y0(list);
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.E(true);
            editorTools.F(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            x0(editorTools);
            ew9.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            vv9 a = vv9.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.T0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void P(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            vv9 vv9Var = this.V;
            if (vv9Var != null) {
                if (TextUtils.isEmpty(vv9Var.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f0fce);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void x0(@NonNull EditorTools editorTools) {
        vv9 vv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, editorTools) != null) || (vv9Var = this.V) == null) {
            return;
        }
        for (String str : vv9Var.e) {
            wv9.a(this.a, editorTools, this, str);
        }
    }

    public final void y0(@NonNull List<zu9<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (zu9<?> zu9Var : list) {
                if (zu9Var instanceof pu9) {
                    this.D = (pu9) zu9Var;
                } else if (zu9Var instanceof eu9) {
                    this.E = (eu9) zu9Var;
                } else if (zu9Var instanceof ou9) {
                    this.F = (ou9) zu9Var;
                } else if (zu9Var instanceof ru9) {
                    this.G = (ru9) zu9Var;
                } else if (zu9Var instanceof su9) {
                    this.H = (su9) zu9Var;
                } else if (zu9Var instanceof du9) {
                    this.I = (du9) zu9Var;
                }
                if (zu9Var != null) {
                    zu9Var.q(list);
                }
            }
        }
    }
}
