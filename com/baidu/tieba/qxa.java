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
/* loaded from: classes7.dex */
public class qxa extends nxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hva V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qxa(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull zva zvaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, zvaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, zvaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (zva) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void M(@NonNull List<awa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(dxa.f(this.a));
            hva e = dxa.e(this.a);
            this.V = e;
            list.add(e);
            fva c = dxa.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            sva p = dxa.p(this.a);
            this.G = p;
            list.add(p);
            list.add(dxa.h(this.a, this.C));
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                fxa.h(this.a, editorTools, this);
                fxa.j(this.a, editorTools, this);
                fxa.k(this.a, editorTools, this);
                fxa.b(this.a, editorTools, this);
                fxa.i(this.a, editorTools);
                fxa.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            fxa.d(editorTools, this);
            fxa.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                li5 g = fxa.g(this.a, editorTools, this);
                g.g(false);
                g.h(false);
            }
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1167));
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
            this.p.setIsEvaluate(true);
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa, com.baidu.tieba.vaa.g
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.a(writeData);
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            vaa.k(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.c0();
            vaa.t(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa, com.baidu.tieba.cwa
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.j();
            vaa.t(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa
    public boolean f0() {
        InterceptResult invokeV;
        fva fvaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((fvaVar = this.E) != null && fvaVar.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nxa, com.baidu.tieba.oxa, com.baidu.tieba.cwa
    public boolean i() {
        InterceptResult invokeV;
        hva hvaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            fva fvaVar = this.E;
            if (fvaVar != null && fvaVar.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (hvaVar = this.V) != null && hvaVar.t()) {
                return super.i();
            }
            e0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
