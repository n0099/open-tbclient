package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class s69 extends q69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z59 V;
    public y59 W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s69(TbPageContext tbPageContext, NavigationBar navigationBar, LinearLayout linearLayout, EditorTools editorTools, c59 c59Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, c59Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, c59Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (c59) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.r69
    public void M(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || this.V == null) {
            return;
        }
        if (this.W == null) {
            this.W = new y59(this.a, this, this.d, this.s, this.J, this.C, this.p);
        }
        list.addAll(this.W.a(this.V.d));
        y0(list);
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void O(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.C(true);
            editorTools.D(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            x0(editorTools);
            i69.m(this.a, editorTools, this.p.getCallFrom(), this);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            if (this.a.getPageActivity() == null) {
                return;
            }
            z59 a = z59.a(this.a.getPageActivity().getIntent().getStringExtra(WriteActivityConfig.DYNAMIC_PARAMS));
            this.V = a;
            if (a == null) {
                this.e.v0(9, true);
            }
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void P(NavigationBar navigationBar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            z59 z59Var = this.V;
            if (z59Var != null) {
                if (TextUtils.isEmpty(z59Var.a)) {
                    str = this.a.getString(R.string.obfuscated_res_0x7f0f0f16);
                } else {
                    str = this.V.a;
                }
                navigationBar.setCenterTextTitle(str);
            }
        }
    }

    public final void x0(EditorTools editorTools) {
        z59 z59Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, editorTools) != null) || (z59Var = this.V) == null) {
            return;
        }
        for (String str : z59Var.e) {
            a69.a(this.a, editorTools, this, str);
        }
    }

    public final void y0(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d59 d59Var = (d59) it.next();
                if (d59Var instanceof t49) {
                    this.D = (t49) d59Var;
                } else if (d59Var instanceof i49) {
                    this.E = (i49) d59Var;
                } else if (d59Var instanceof s49) {
                    this.F = (s49) d59Var;
                } else if (d59Var instanceof v49) {
                    this.G = (v49) d59Var;
                } else if (d59Var instanceof w49) {
                    this.H = (w49) d59Var;
                } else if (d59Var instanceof h49) {
                    this.I = (h49) d59Var;
                }
                if (d59Var != null) {
                    d59Var.q(list);
                }
            }
        }
    }
}
