package com.baidu.tieba;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class t69 extends q69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k69 V;
    public k49 W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t69(TbPageContext tbPageContext, NavigationBar navigationBar, LinearLayout linearLayout, EditorTools editorTools, c59 c59Var, boolean z) {
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
        this.V = new k69(tbPageContext, this);
    }

    @Override // com.baidu.tieba.r69
    public void M(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(g69.f(this.a));
            k49 e = g69.e(this.a);
            this.W = e;
            list.add(e);
            i49 c = g69.c(this.a, this, this.d, this.s, this.V);
            this.E = c;
            list.add(c);
            v49 p = g69.p(this.a);
            this.G = p;
            list.add(p);
            list.add(g69.h(this.a, this.C));
        }
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
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                i69.h(this.a, editorTools, this);
                i69.j(this.a, editorTools, this);
                i69.k(this.a, editorTools, this);
                i69.b(this.a, editorTools, this);
                i69.i(this.a, editorTools);
                i69.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            i69.d(editorTools, this);
            i69.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                k65 g = i69.g(this.a, editorTools, this);
                g.g(false);
                g.h(false);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void P(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f67));
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69, com.baidu.tieba.um8.g
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.a(writeData);
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            um8.j(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c0();
            um8.s(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69, com.baidu.tieba.f59
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.j();
            um8.s(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69
    public boolean e0() {
        InterceptResult invokeV;
        i49 i49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((i49Var = this.E) != null && i49Var.t()) || this.C.f().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q69, com.baidu.tieba.r69, com.baidu.tieba.f59
    public boolean i() {
        InterceptResult invokeV;
        k49 k49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            i49 i49Var = this.E;
            if (i49Var != null && i49Var.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (k49Var = this.W) != null && k49Var.t()) {
                return super.i();
            }
            d0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
