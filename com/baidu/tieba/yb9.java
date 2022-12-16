package com.baidu.tieba;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class yb9 extends zb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb9(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull ga9 ga9Var, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, ga9Var, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, ga9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (ga9) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.zb9, com.baidu.tieba.ub9, com.baidu.tieba.vb9
    public void M(@NonNull List<ha9<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            list.add(kb9.i(this.a));
            super.M(list);
        }
    }

    @Override // com.baidu.tieba.zb9, com.baidu.tieba.ub9, com.baidu.tieba.vb9
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) {
            super.O(editorTools);
            x65 o = editorTools.o(15);
            if (o instanceof x79) {
                ((x79) o).n(false);
            }
        }
    }

    @Override // com.baidu.tieba.zb9, com.baidu.tieba.ub9, com.baidu.tieba.vb9
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0f64));
        }
    }

    @Override // com.baidu.tieba.ub9, com.baidu.tieba.vb9
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.U(bundle);
            this.K.C(true);
        }
    }

    @Override // com.baidu.tieba.ub9, com.baidu.tieba.vb9
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            or8.l(this);
        }
    }

    @Override // com.baidu.tieba.ub9, com.baidu.tieba.vb9
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.c0();
            or8.v(this.p);
        }
    }

    @Override // com.baidu.tieba.ub9, com.baidu.tieba.vb9, com.baidu.tieba.ja9
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.j();
            or8.v(null);
        }
    }
}
