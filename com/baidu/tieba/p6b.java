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
public class p6b extends m6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g4b V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p6b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull y4b y4bVar, boolean z) {
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
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(c6b.f(this.a));
            g4b e = c6b.e(this.a);
            this.V = e;
            list.add(e);
            e4b c = c6b.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            r4b p = c6b.p(this.a);
            this.G = p;
            list.add(p);
            list.add(c6b.h(this.a, this.C));
        }
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
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.p.getFrom())) {
                e6b.h(this.a, editorTools, this);
                e6b.j(this.a, editorTools, this);
                e6b.k(this.a, editorTools, this);
                e6b.b(this.a, editorTools, this);
                e6b.i(this.a, editorTools);
                e6b.m(this.a, editorTools, this.p.getCallFrom(), this);
            }
            e6b.d(editorTools, this);
            e6b.a(this.a, editorTools, this);
            if (StringHelper.equals("2", this.p.getCallFrom())) {
                sj5 g = e6b.g(this.a, editorTools, this);
                g.g(false);
                g.h(false);
            }
            editorTools.f();
            super.N(editorTools);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.O(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f118b));
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.T(bundle);
            this.p.setIsNoTitle(true);
            this.p.setTitle("");
            this.p.setIsEvaluate(true);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b, com.baidu.tieba.wga.h
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, writeData) != null) || writeData == null || writeData.getType() != 12) {
            return;
        }
        super.c(writeData);
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            wga.m(this.p.getItem_id(), this);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            wga.w(this.p.getItem_id(), null);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.c0();
            wga.w(this.p.getItem_id(), this.p);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public boolean e0() {
        InterceptResult invokeV;
        e4b e4bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.p.isSaveDraft() && this.l != null && (((e4bVar = this.E) != null && e4bVar.t()) || this.C.g().size() != 0)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public boolean j() {
        InterceptResult invokeV;
        g4b g4bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            e4b e4bVar = this.E;
            if (e4bVar != null && e4bVar.t() && this.E.p() != null && this.E.p().getText().length() >= 20 && this.E.p().getText().length() <= 500 && (g4bVar = this.V) != null && g4bVar.t()) {
                return super.j();
            }
            d0(false);
            return false;
        }
        return invokeV.booleanValue;
    }
}
