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
public class n89 extends k89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e89 V;
    public e69 W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n89(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull w69 w69Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, w69Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, w69Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (w69) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.V = new e89(tbPageContext, this);
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public void M(@NonNull List<x69<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(a89.f(this.a));
            e69 e = a89.e(this.a);
            this.W = e;
            list.add(e);
            c69 c = a89.c(this.a, this, this.d, this.s, this.V);
            this.E = c;
            list.add(c);
            p69 p = a89.p(this.a);
            this.G = p;
            list.add(p);
            list.add(a89.h(this.a, this.C));
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.C(true);
            editorTools.D(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                c89.h(this.a, editorTools, this);
                c89.j(this.a, editorTools, this);
                c89.k(this.a, editorTools, this);
                c89.b(this.a, editorTools, this);
                c89.i(this.a, editorTools);
                c89.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            c89.d(editorTools, this);
            c89.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                j75 g = c89.g(this.a, editorTools, this);
                g.g(false);
                g.h(false);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f84));
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89, com.baidu.tieba.oo8.g
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.a(writeData);
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            oo8.j(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c0();
            oo8.s(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89, com.baidu.tieba.z69
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.j();
            oo8.s(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89
    public boolean e0() {
        InterceptResult invokeV;
        c69 c69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((c69Var = this.E) != null && c69Var.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k89, com.baidu.tieba.l89, com.baidu.tieba.z69
    public boolean i() {
        InterceptResult invokeV;
        e69 e69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c69 c69Var = this.E;
            if (c69Var != null && c69Var.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (e69Var = this.W) != null && e69Var.t()) {
                return super.i();
            }
            d0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
