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
public class jaa extends haa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public q9a V;
    public p9a W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jaa(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull t8a t8aVar, boolean z) {
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

    @Override // com.baidu.tieba.haa, com.baidu.tieba.iaa
    public void M(@NonNull List<u8a<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new p9a(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        y0(list);
    }

    @Override // com.baidu.tieba.haa, com.baidu.tieba.iaa
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
            z9a.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.haa, com.baidu.tieba.iaa
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            q9a a = q9a.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.U0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.haa, com.baidu.tieba.iaa
    public void P(@NonNull NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            q9a q9aVar = this.V;
            if (q9aVar != null) {
                if (TextUtils.isEmpty(q9aVar.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f0fdf);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void x0(@NonNull EditorTools editorTools) {
        q9a q9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, editorTools) != null) || (q9aVar = this.V) == null) {
            return;
        }
        for (String str : q9aVar.e) {
            r9a.a(this.a, editorTools, this, str);
        }
    }

    public final void y0(@NonNull List<u8a<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (u8a<?> u8aVar : list) {
                if (u8aVar instanceof k8a) {
                    this.D = (k8a) u8aVar;
                } else if (u8aVar instanceof z7a) {
                    this.E = (z7a) u8aVar;
                } else if (u8aVar instanceof j8a) {
                    this.F = (j8a) u8aVar;
                } else if (u8aVar instanceof m8a) {
                    this.G = (m8a) u8aVar;
                } else if (u8aVar instanceof n8a) {
                    this.H = (n8a) u8aVar;
                } else if (u8aVar instanceof y7a) {
                    this.I = (y7a) u8aVar;
                }
                if (u8aVar != null) {
                    u8aVar.q(list);
                }
            }
        }
    }
}
