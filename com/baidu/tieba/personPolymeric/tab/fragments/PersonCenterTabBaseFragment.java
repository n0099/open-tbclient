package com.baidu.tieba.personPolymeric.tab.fragments;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n68;
import tbclient.User;
/* loaded from: classes3.dex */
public abstract class PersonCenterTabBaseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n68 a;

    public PersonCenterTabBaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void C0(boolean z);

    public abstract int D0();

    public abstract boolean E0();

    public void F0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, metaData) == null) {
        }
    }

    public abstract void G0(User user);

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        n68 n68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || (n68Var = this.a) == null) {
            return;
        }
        n68Var.dettachView(view2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            n68 n68Var = this.a;
            if (n68Var != null) {
                n68Var.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, view2, str, z) == null) {
            if (this.a == null) {
                n68 n68Var = new n68(getPageContext().getPageActivity(), getNetRefreshListener());
                this.a = n68Var;
                n68Var.e(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0f84));
                this.a.d(null);
                this.a.c(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0f83));
                this.a.f();
                this.a.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.a.onChangeSkinType();
            this.a.attachView(view2, z);
        }
    }
}
