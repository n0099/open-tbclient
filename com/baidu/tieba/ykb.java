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
/* loaded from: classes9.dex */
public class ykb extends wkb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public fkb V;
    public ekb W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ykb(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull ijb ijbVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, ijbVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, ijbVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (ijb) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.wkb, com.baidu.tieba.xkb
    public void K(@NonNull List<jjb<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new ekb(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        z0(list);
    }

    @Override // com.baidu.tieba.wkb, com.baidu.tieba.xkb
    public void M(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.M(true);
            editorTools.N(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            y0(editorTools);
            okb.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.h();
            super.M(editorTools);
        }
    }

    @Override // com.baidu.tieba.wkb, com.baidu.tieba.xkb
    public void S(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.S(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            fkb a = fkb.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.L0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.wkb, com.baidu.tieba.xkb
    public void N(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.N(navigationBar);
            fkb fkbVar = this.V;
            if (fkbVar != null) {
                if (TextUtils.isEmpty(fkbVar.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f116f);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void y0(@NonNull EditorTools editorTools) {
        fkb fkbVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, editorTools) != null) || (fkbVar = this.V) == null) {
            return;
        }
        for (String str : fkbVar.e) {
            gkb.a(this.a, editorTools, this, str);
        }
    }

    public final void z0(@NonNull List<jjb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (jjb<?> jjbVar : list) {
                if (jjbVar instanceof zib) {
                    this.D = (zib) jjbVar;
                } else if (jjbVar instanceof oib) {
                    this.E = (oib) jjbVar;
                } else if (jjbVar instanceof yib) {
                    this.F = (yib) jjbVar;
                } else if (jjbVar instanceof bjb) {
                    this.G = (bjb) jjbVar;
                } else if (jjbVar instanceof cjb) {
                    this.H = (cjb) jjbVar;
                } else if (jjbVar instanceof nib) {
                    this.I = (nib) jjbVar;
                }
                if (jjbVar != null) {
                    jjbVar.q(list);
                }
            }
        }
    }
}
