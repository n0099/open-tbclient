package com.baidu.tieba;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
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
public class pw9 extends mw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gw9 V;
    public gu9 W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pw9(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull yu9 yu9Var, boolean z) {
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
        this.V = new gw9(tbPageContext, this);
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void M(@NonNull List<zu9<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(cw9.f(this.a));
            gu9 e = cw9.e(this.a);
            this.W = e;
            list.add(e);
            eu9 c = cw9.c(this.a, this, this.d, this.s, this.V);
            this.E = c;
            list.add(c);
            ru9 p = cw9.p(this.a);
            this.G = p;
            list.add(p);
            list.add(cw9.h(this.a, this.C));
        }
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
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                ew9.h(this.a, editorTools, this);
                ew9.j(this.a, editorTools, this);
                ew9.k(this.a, editorTools, this);
                ew9.b(this.a, editorTools, this);
                ew9.i(this.a, editorTools);
                ew9.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            ew9.d(editorTools, this);
            ew9.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                kc5 g = ew9.g(this.a, editorTools, this);
                g.g(false);
                g.h(false);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1015));
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9, com.baidu.tieba.eb9.g
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.a(writeData);
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            eb9.k(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c0();
            eb9.t(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9, com.baidu.tieba.bv9
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.j();
            eb9.t(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9
    public boolean e0() {
        InterceptResult invokeV;
        eu9 eu9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((eu9Var = this.E) != null && eu9Var.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mw9, com.baidu.tieba.nw9, com.baidu.tieba.bv9
    public boolean i() {
        InterceptResult invokeV;
        gu9 gu9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            eu9 eu9Var = this.E;
            if (eu9Var != null && eu9Var.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (gu9Var = this.W) != null && gu9Var.t()) {
                return super.i();
            }
            d0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
